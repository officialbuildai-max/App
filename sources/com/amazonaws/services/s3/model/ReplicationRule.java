package com.amazonaws.services.s3.model;

/* loaded from: classes2.dex */
public class ReplicationRule {

    /* renamed from: a, reason: collision with root package name */
    private String f18875a;

    /* renamed from: b, reason: collision with root package name */
    private String f18876b;

    /* renamed from: c, reason: collision with root package name */
    private ReplicationDestinationConfig f18877c;

    public void a(ReplicationDestinationConfig replicationDestinationConfig) {
        if (replicationDestinationConfig == null) {
            throw new IllegalArgumentException("Destination cannot be null in the replication rule");
        }
        this.f18877c = replicationDestinationConfig;
    }

    public void b(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Prefix cannot be null for a replication rule");
        }
        this.f18875a = str;
    }

    public void c(String str) {
        this.f18876b = str;
    }
}
