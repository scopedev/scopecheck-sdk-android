package com.scopemedia.scopescheck.client;

import okhttp3.logging.HttpLoggingInterceptor;

/**
 * @author Maikel Rehl on 6/7/2017.
 */

public class ScopeCheckBuilder {
    private String appId;
    private String clientId;
    private String clientSecret;
    private String clientNode;
    private boolean debugMode = false;
    private HttpLoggingInterceptor.Level debugLevel = HttpLoggingInterceptor.Level.BASIC;

    public static final String DEFAULT_APP_ID = "fashion";
    private String baseUrl = "https://api.scopemedia.com/";

    /**
     * Create a new {@link ScopeCheckBuilder} object with the DEFAULT_APP_ID = 'fashion'
     * @param clientId set your ClientID
     * @param clientSecret set your ClientSecret
     */
    public ScopeCheckBuilder(String clientId, String clientSecret) {
        this(clientId, clientSecret, DEFAULT_APP_ID);
    }

    /**
     * Create a new ScopeCheckBuilder object
     * @param clientId set your ClientID
     * @param clientSecret set your ClientSecret
     * @param appId set your AppID
     */
    public ScopeCheckBuilder(String clientId, String clientSecret, String appId) {
        this.appId = appId;
        this.clientId = clientId;
        this.clientSecret = clientSecret;
    }

    /**
     * Create a new ScopeCheckBuilder object
     * @param clientId set your ClientID
     * @param clientSecret set your ClientSecret
     * @param clientNode set your ClientNode
     * @param appId set your AppID
     */
    public ScopeCheckBuilder(String clientId, String clientSecret, String clientNode, String appId) {
        this.appId = appId;
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.clientNode = clientNode;
    }

    /**
     * Create a new ScopeCheckBuilder object
     * @param clientId set your ClientID
     * @param clientSecret set your ClientSecret
     * @param clientNode set your ClientNode
     * @param appId set your AppID
     * @param baseUrl set API Base URL
     */
    public ScopeCheckBuilder(String clientId, String clientSecret, String clientNode, String appId, String baseUrl) {
        this.appId = appId;
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.clientNode = clientNode;
        this.baseUrl = baseUrl;
    }

    /**
     * Enable the debug mode for all requests and responds
     * @param enable true or false
     * @return ScopeCheckBuilder
     */
    public ScopeCheckBuilder setDebugMode(boolean enable) {
        this.debugMode = enable;
        return this;
    }

    /**
     * Set the debugging level
     * @param level {@link okhttp3.logging.HttpLoggingInterceptor.Level}
     * @return ScopeCheckBuilder
     */
    public ScopeCheckBuilder setDebugLevel(HttpLoggingInterceptor.Level level) {
        this.debugLevel = level;
        return this;
    }

    /**
     * Build the client
     * @return {@link ScopeCheckClient}
     */
    public ScopeCheckClient build() {
        return new ScopeCheckClientImpl(this);
    }

    /**
     * Build the client
     * @return {@link ScopeCheckClient}
     * @param timeout in second
     */
    public ScopeCheckClient build(long timeout) {
        return new ScopeCheckClientImpl(this, timeout);
    }

    /**
     * @return returns the API Base URL
     */
    protected String getBaseUrl() {
        return baseUrl;
    }

    /**
     * @return returns the AppId
     */
    public String getAppId() {
        return appId;
    }

    /**
     * @return returns the ClientId
     */
    public String getClientId() {
        return clientId;
    }

    /**
     * @return returns the ClientSecret
     */
    public String getClientSecret() {
        return clientSecret;
    }

    /**
     * @return returns the ClientNode
     */
    public String getClientNode() {
        return clientNode;
    }

    /**
     * @return returns if the debug mode is enabled
     */
    public boolean getDebugMode() {
        return debugMode;
    }

    /**
     * @return returns the debug {@link okhttp3.logging.HttpLoggingInterceptor.Level}
     */
    public HttpLoggingInterceptor.Level getDebugLevel() {
        return debugLevel;
    }
}