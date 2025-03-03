from flask import Flask, request, jsonify
import joblib
import numpy as np

app = Flask(__name__)

# Load trained model
model = joblib.load("user_behavior_model.pkl")

@app.route("/predict", methods=["POST"])
def predict():
    data = request.get_json()
    age = data["age"]
    gender = 0 if data["gender"] == "Male" else 1
    browsing_history_length = len(data["browsing_history"].split(","))

    # Prepare input
    features = np.array([[age, gender, browsing_history_length]])
    
    # Prediction
    prediction = model.predict(features)[0]

    return jsonify({"purchase_prediction": bool(prediction)})

if __name__ == "__main__":
    app.run(host="0.0.0.0", port=5001)
