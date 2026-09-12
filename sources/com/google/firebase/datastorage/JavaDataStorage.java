package com.google.firebase.datastorage;

import android.content.Context;
import android.os.Process;
import android.util.Log;
import androidx.datastore.core.CorruptionException;
import androidx.datastore.core.f;
import androidx.datastore.preferences.PreferenceDataStoreDelegateKt;
import androidx.datastore.preferences.SharedPreferencesMigrationKt;
import androidx.datastore.preferences.core.c;
import androidx.datastore.preferences.core.d;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference2Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.j;

/* loaded from: classes4.dex */
public final class JavaDataStorage {

    /* renamed from: f, reason: collision with root package name */
    static final /* synthetic */ KProperty[] f31862f = {Reflection.j(new PropertyReference2Impl(JavaDataStorage.class, "dataStore", "getDataStore(Landroid/content/Context;)Landroidx/datastore/core/DataStore;", 0))};

    /* renamed from: a, reason: collision with root package name */
    private final Context f31863a;

    /* renamed from: b, reason: collision with root package name */
    private final String f31864b;

    /* renamed from: c, reason: collision with root package name */
    private final ThreadLocal f31865c;

    /* renamed from: d, reason: collision with root package name */
    private final ReadOnlyProperty f31866d;

    /* renamed from: e, reason: collision with root package name */
    private final f f31867e;

    public JavaDataStorage(Context context, String name) {
        Intrinsics.h(context, "context");
        Intrinsics.h(name, "name");
        this.f31863a = context;
        this.f31864b = name;
        this.f31865c = new ThreadLocal();
        this.f31866d = PreferenceDataStoreDelegateKt.b(name, new j1.b(new Function1() { // from class: com.google.firebase.datastorage.a
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                androidx.datastore.preferences.core.c e11;
                e11 = JavaDataStorage.e(JavaDataStorage.this, (CorruptionException) obj);
                return e11;
            }
        }), new Function1() { // from class: com.google.firebase.datastorage.b
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                List f11;
                f11 = JavaDataStorage.f(JavaDataStorage.this, (Context) obj);
                return f11;
            }
        }, null, 8, null);
        this.f31867e = i(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final androidx.datastore.preferences.core.c e(JavaDataStorage javaDataStorage, CorruptionException ex2) {
        Intrinsics.h(ex2, "ex");
        Log.w(Reflection.b(JavaDataStorage.class).g(), "CorruptionException in " + javaDataStorage.f31864b + " DataStore running in process " + Process.myPid(), ex2);
        return d.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List f(JavaDataStorage javaDataStorage, Context it) {
        Intrinsics.h(it, "it");
        return CollectionsKt.e(SharedPreferencesMigrationKt.b(it, javaDataStorage.f31864b, null, 4, null));
    }

    private final f i(Context context) {
        return (f) this.f31866d.a(context, f31862f[0]);
    }

    public final androidx.datastore.preferences.core.c g(Function1 transform) {
        Object b11;
        Intrinsics.h(transform, "transform");
        b11 = j.b(null, new JavaDataStorage$editSync$1(this, transform, null), 1, null);
        return (androidx.datastore.preferences.core.c) b11;
    }

    public final Map h() {
        Object b11;
        b11 = j.b(null, new JavaDataStorage$getAllSync$1(this, null), 1, null);
        return (Map) b11;
    }

    public final Object j(c.a key, Object obj) {
        Object b11;
        Intrinsics.h(key, "key");
        b11 = j.b(null, new JavaDataStorage$getSync$1(this, key, obj, null), 1, null);
        return b11;
    }

    public final androidx.datastore.preferences.core.c k(c.a key, Object obj) {
        Object b11;
        Intrinsics.h(key, "key");
        b11 = j.b(null, new JavaDataStorage$putSync$1(this, key, obj, null), 1, null);
        return (androidx.datastore.preferences.core.c) b11;
    }
}
