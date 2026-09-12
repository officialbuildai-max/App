package com.amazonaws.internal.config;

import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/* loaded from: classes2.dex */
public class HostRegexToRegionMapping {

    /* renamed from: a, reason: collision with root package name */
    private final String f18496a;

    /* renamed from: b, reason: collision with root package name */
    private final String f18497b;

    public HostRegexToRegionMapping(String str, String str2) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Invalid HostRegexToRegionMapping configuration: hostNameRegex must be non-empty");
        }
        try {
            Pattern.compile(str);
            if (str2 == null || str2.isEmpty()) {
                throw new IllegalArgumentException("Invalid HostRegexToRegionMapping configuration: regionName must be non-empty");
            }
            this.f18496a = str;
            this.f18497b = str2;
        } catch (PatternSyntaxException e11) {
            throw new IllegalArgumentException("Invalid HostRegexToRegionMapping configuration: hostNameRegex is not a valid regex", e11);
        }
    }

    public String a() {
        return this.f18496a;
    }

    public String b() {
        return this.f18497b;
    }
}
