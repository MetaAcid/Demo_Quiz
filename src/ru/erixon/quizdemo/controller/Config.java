package ru.erixon.quizdemo.controller;

public class Config {
    private final String DEFAULT_SCHEMA = "public";
    private String schema;

    public Config() {
        init();
    }


    private void init(){
        String schema = System.getProperty("schema");
        this.schema = schema == null ? DEFAULT_SCHEMA:schema;
    }

    public String getSchema() {
        return schema;
    }
}
