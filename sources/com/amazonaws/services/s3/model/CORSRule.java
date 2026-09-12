package com.amazonaws.services.s3.model;

import java.util.List;

/* loaded from: classes2.dex */
public class CORSRule {

    /* renamed from: a, reason: collision with root package name */
    private String f18769a;

    /* renamed from: b, reason: collision with root package name */
    private List f18770b;

    /* renamed from: c, reason: collision with root package name */
    private List f18771c;

    /* renamed from: d, reason: collision with root package name */
    private int f18772d;

    /* renamed from: e, reason: collision with root package name */
    private List f18773e;

    /* renamed from: f, reason: collision with root package name */
    private List f18774f;

    /* loaded from: classes2.dex */
    public enum AllowedMethods {
        GET("GET"),
        PUT("PUT"),
        HEAD("HEAD"),
        POST("POST"),
        DELETE("DELETE");

        private final String AllowedMethod;

        AllowedMethods(String str) {
            this.AllowedMethod = str;
        }

        public static AllowedMethods fromValue(String str) throws IllegalArgumentException {
            for (AllowedMethods allowedMethods : values()) {
                String allowedMethods2 = allowedMethods.toString();
                if (allowedMethods2 == null && str == null) {
                    return allowedMethods;
                }
                if (allowedMethods2 != null && allowedMethods2.equals(str)) {
                    return allowedMethods;
                }
            }
            throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.AllowedMethod;
        }
    }

    public void a(List list) {
        this.f18774f = list;
    }

    public void b(List list) {
        this.f18770b = list;
    }

    public void c(List list) {
        this.f18771c = list;
    }

    public void d(List list) {
        this.f18773e = list;
    }

    public void e(String str) {
        this.f18769a = str;
    }

    public void f(int i11) {
        this.f18772d = i11;
    }
}
