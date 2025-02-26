package com.example.myfirstapplication;
import android.car.Car;
import android.car.hardware.CarPropertyManager;
import android.car.hardware.property.CarPropertyEvent;
import android.car.hardware.property.CarPropertyEventCallback;
import android.car.hardware.property.VehiclePropertyIds;
import android.content.Context;
import android.util.Log;

public class SpeedCheck {

    private static final String TAG = "SpeedCheck";
    private static final float SPEED_LIMIT_KMH = 80.0f; // Set your speed limit

    private Car car;
    private CarPropertyManager carPropertyManager;
    private Context context;

    public SpeedCheck(Context context) {
        this.context = context;
        initCarPropertyManager();
    }

    private void initCarPropertyManager() {
        car = Car.createCar(context);
        carPropertyManager = (CarPropertyManager) car.getCarManager(Car.PROPERTY_SERVICE);

        if (carPropertyManager != null) {
            carPropertyManager.registerCallback(carPropertyEventCallback,
                    VehiclePropertyIds.PERF_VEHICLE_SPEED, CarPropertyManager.SENSOR_RATE_ONCHANGE);
        }
    }

    private final CarPropertyEventCallback carPropertyEventCallback = new CarPropertyEventCallback() {
        @Override
        public void onChangeEvent(CarPropertyEvent event) {
            if (event.getEventType() != CarPropertyEvent.PROPERTY_EVENT_PROPERTY_CHANGE) {
                return;
            }

            if (event.getCarPropertyValue().getPropertyId() == VehiclePropertyIds.PERF_VEHICLE_SPEED) {
                float speed = (float) event.getCarPropertyValue().getValue();
                Log.d(TAG, "Current Speed: " + speed + " km/h");

                if (speed > SPEED_LIMIT_KMH) {
                    Log.w(TAG, "Over Speed Detected! Current Speed: " + speed + " km/h");
                    onSpeedLimitExceeded(speed);
                }
            }
        }

        @Override
        public void onErrorEvent(int propertyId, int zone) {
            Log.e(TAG, "Wrong data.");
        }
    };

    private void onSpeedLimitExceeded(float speed) {
    }

}
