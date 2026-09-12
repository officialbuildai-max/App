package com.amazonaws.services.s3.model;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class TagSet {

    /* renamed from: a, reason: collision with root package name */
    private Map f18911a;

    public TagSet() {
        this.f18911a = new HashMap(1);
    }

    public TagSet(Map map) {
        HashMap hashMap = new HashMap(1);
        this.f18911a = hashMap;
        hashMap.putAll(map);
    }

    public Map a() {
        return this.f18911a;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("{");
        stringBuffer.append("Tags: " + a());
        stringBuffer.append("}");
        return stringBuffer.toString();
    }
}
