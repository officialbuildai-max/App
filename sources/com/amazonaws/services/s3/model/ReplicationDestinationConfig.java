package com.amazonaws.services.s3.model;

/* loaded from: classes2.dex */
public class ReplicationDestinationConfig {

    /* renamed from: a, reason: collision with root package name */
    private String f18873a;

    /* renamed from: b, reason: collision with root package name */
    private String f18874b;

    public void a(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Bucket name cannot be null");
        }
        this.f18873a = str;
    }

    public void b(String str) {
        this.f18874b = str;
    }
}
