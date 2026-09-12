package com.transsion.api.gateway.dns;

import java.math.BigInteger;
import java.util.Arrays;

/* loaded from: classes5.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public final int f42575a;

    /* renamed from: b, reason: collision with root package name */
    public String f42576b;

    /* renamed from: c, reason: collision with root package name */
    public int f42577c;

    /* renamed from: d, reason: collision with root package name */
    public int f42578d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f42579e;

    /* renamed from: f, reason: collision with root package name */
    public String f42580f;

    /* renamed from: g, reason: collision with root package name */
    public BigInteger f42581g;

    public d(d dVar) {
        this.f42577c = 0;
        this.f42578d = 0;
        this.f42579e = false;
        char[] cArr = new char[16];
        Arrays.fill(cArr, 'f');
        this.f42580f = new String(cArr);
        this.f42581g = new BigInteger(this.f42580f, 16);
        this.f42576b = dVar.f42576b;
        this.f42575a = dVar.f42575a;
        this.f42577c = dVar.f42577c;
        this.f42578d = dVar.f42578d;
        this.f42579e = dVar.f42579e;
        this.f42581g = dVar.f42581g;
        this.f42580f = dVar.f42580f;
    }

    public d(String str, int i11) {
        this.f42577c = 0;
        this.f42578d = 0;
        this.f42579e = false;
        char[] cArr = new char[16];
        Arrays.fill(cArr, 'f');
        this.f42580f = new String(cArr);
        this.f42581g = new BigInteger(this.f42580f, 16);
        this.f42576b = str;
        this.f42575a = i11;
    }
}
