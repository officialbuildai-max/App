package com.amazonaws;

import java.util.Map;

/* loaded from: classes2.dex */
public abstract class ResponseMetadata {

    /* renamed from: a, reason: collision with root package name */
    protected final Map f18401a;

    public ResponseMetadata(Map map) {
        this.f18401a = map;
    }

    public String a() {
        return (String) this.f18401a.get("AWS_REQUEST_ID");
    }

    public String toString() {
        Map map = this.f18401a;
        return map == null ? "{}" : map.toString();
    }
}
