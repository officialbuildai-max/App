package com.bykv.vk.openvk.preload.geckox.a.a;

import android.annotation.SuppressLint;
import java.io.File;
import java.util.List;

@SuppressLint({"CI_StaticFieldLeak"})
/* loaded from: classes2.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f20671a = new d();

    /* renamed from: b, reason: collision with root package name */
    public static final b f20672b;

    /* renamed from: c, reason: collision with root package name */
    protected a f20673c;

    /* renamed from: d, reason: collision with root package name */
    protected File f20674d;

    /* renamed from: e, reason: collision with root package name */
    protected List<String> f20675e;

    static {
        new f();
        f20672b = new e();
    }

    public abstract void a();

    public void a(a aVar, File file, List<String> list) {
        this.f20673c = aVar;
        this.f20674d = file;
        this.f20675e = list;
    }
}
