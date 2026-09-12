package com.transsion.transfer.androidasync.util;

import java.util.Hashtable;

/* loaded from: classes6.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private Hashtable f55691a = new Hashtable();

    public Object a(String str) {
        return this.f55691a.get(str);
    }

    public void b(String str, Object obj) {
        this.f55691a.put(str, obj);
    }
}
