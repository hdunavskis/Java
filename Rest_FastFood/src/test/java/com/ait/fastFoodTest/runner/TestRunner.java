package com.ait.fastFoodTest.runner;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="projectfeatures", glue="com.ait.Rest_FastFood.test")
public class TestRunner {
}