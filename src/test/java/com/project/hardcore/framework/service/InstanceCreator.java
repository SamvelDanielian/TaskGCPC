package com.project.hardcore.framework.service;

import com.project.hardcore.framework.model.Instance;

public class InstanceCreator {
    public static final String TESTDATA_NUMBER_OF_INSTANCES = "testdata.num.of.instances";
    public static final String TESTDATA_LOCAL_SSD = "testdata.local.ssd";
    public static final String TESTDATA_DATA_CENTER_LOCATION = "testdata.data.center.location";

    public static Instance withCredentialsFromProperty(){
        return new Instance(TestDataReader.getTestData(TESTDATA_NUMBER_OF_INSTANCES), TestDataReader.getTestData(TESTDATA_LOCAL_SSD), TestDataReader.getTestData(TESTDATA_DATA_CENTER_LOCATION));
    }
    public static Instance withEmptyNumberOfInstances(){
        return new Instance("", TestDataReader.getTestData(TESTDATA_LOCAL_SSD), TestDataReader.getTestData(TESTDATA_DATA_CENTER_LOCATION));
    }
    public static Instance withEmptyLocalSSD(){
        return new Instance(TestDataReader.getTestData(TESTDATA_NUMBER_OF_INSTANCES), "", TestDataReader.getTestData(TESTDATA_DATA_CENTER_LOCATION));
    }
    public static Instance withEmptyDatacenterLocation(){
        return new Instance(TestDataReader.getTestData(TESTDATA_NUMBER_OF_INSTANCES), TestDataReader.getTestData(TESTDATA_LOCAL_SSD), "");
    }
}
