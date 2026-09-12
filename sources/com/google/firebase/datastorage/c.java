package com.google.firebase.datastorage;

import androidx.datastore.preferences.core.c;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public abstract class c {
    public static final Object a(androidx.datastore.preferences.core.c cVar, c.a key, Object obj) {
        Intrinsics.h(cVar, "<this>");
        Intrinsics.h(key, "key");
        Object b11 = cVar.b(key);
        return b11 == null ? obj : b11;
    }
}
