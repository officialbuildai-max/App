package com.bytedance.sdk.component.Sj;

/* loaded from: classes2.dex */
public enum ib {
    PUBLIC,
    PROTECTED,
    PRIVATE;

    @Override // java.lang.Enum
    public String toString() {
        return this == PRIVATE ? "private" : this == PROTECTED ? "protected" : "public";
    }
}
