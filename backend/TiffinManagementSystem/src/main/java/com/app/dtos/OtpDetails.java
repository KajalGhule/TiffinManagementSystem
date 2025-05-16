package com.app.dtos;

public class OtpDetails {
    private int otp;
    private long expiryTime; // in milliseconds

    public OtpDetails(int otp, long expiryTime) {
        this.otp = otp;
        this.expiryTime = expiryTime;
    }

    public int getOtp() {
        return otp;
    }

    public long getExpiryTime() {
        return expiryTime;
    }
}
