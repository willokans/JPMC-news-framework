package com.util;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentReporterFactory {

    public static void main(String[] args) {
        ExtentReports extentReports = new ExtentReports();
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("src//main//java//com//report//report.html");
        extentReports.attachReporter(sparkReporter);
        extentReports.flush();
    }

//    public static void getInstance(){
//        ExtentReports extentReports = new ExtentReports();
//        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("src/main/java/com/report/report.html");
//        extentReports.attachReporter(sparkReporter);
////
////        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM_dd_hh_mm_ss");
////        String dateString = simpleDateFormat.format(new Date());
//
//        extentReports.flush();
//
//    }


}
