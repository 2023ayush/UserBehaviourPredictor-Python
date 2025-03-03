import pandas as pd
import joblib
from sklearn.model_selection import train_test_split
from sklearn.ensemble import RandomForestClassifier
from mysql.connector import connect

# Connect to MySQL and load data
conn = connect(host="localhost", user="root", password="test", database="userpredictiondb")
query = "SELECT age, gender, browsing_history, purchase_made FROM user_behavior"
df = pd.read_sql(query, conn)
conn.close()

# Preprocessing (Convert categorical to numerical)
df["gender"] = df["gender"].map({"Male": 0, "Female": 1})
df["browsing_history"] = df["browsing_history"].apply(lambda x: len(x.split(",")))  # Convert to length

# Features & Labels
X = df.drop(columns=["purchase_made"])
y = df["purchase_made"]

# Train-Test Split
X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.2, random_state=42)

# Train Model
model = RandomForestClassifier(n_estimators=100, random_state=42)
model.fit(X_train, y_train)

# Save Model
joblib.dump(model, "user_behavior_model.pkl")
print("Model trained and saved successfully!")
