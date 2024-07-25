package org.example.reports;

import com.aventstack.extentreports.MediaEntityBuilder;
import org.example.utils.MyUtils;
import org.example.utils.PropertyUtils;

public final class ExtentLogger {
    private ExtentLogger() {}


    public static void pass(String message){
        ExtentManager.getTest().pass(message);
    }
    public static void fail(String message){
        ExtentManager.getTest().fail(message);
    }
    public static void skip(String message){
        ExtentManager.getTest().skip(message);
    }

    public static void pass(String message, boolean isScreenshotNeeded) {
        try {
            if(PropertyUtils.get("passedstepsscreenshot").equalsIgnoreCase("yes") && isScreenshotNeeded){
                ExtentManager.getTest().pass(message,
                        MediaEntityBuilder.createScreenCaptureFromBase64String(MyUtils.getBase64Image()).build());
            }else {
                pass(message );
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void fail(String message, boolean isScreenshotNeeded) {
        try {
            if(PropertyUtils.get("failedstepsscreenshot").equalsIgnoreCase("yes") && isScreenshotNeeded){
                ExtentManager.getTest().fail(message,
                        MediaEntityBuilder.createScreenCaptureFromBase64String(MyUtils.getBase64Image()).build());
            }else {
                fail(message );
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void skip(String message, boolean isScreenshotNeeded) {
        try {
            if(PropertyUtils.get("skippedstepsscreenshot").equalsIgnoreCase("yes") && isScreenshotNeeded){
                ExtentManager.getTest().skip(message,
                        MediaEntityBuilder.createScreenCaptureFromBase64String(MyUtils.getBase64Image()).build());
            } else {
                skip(message );
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
