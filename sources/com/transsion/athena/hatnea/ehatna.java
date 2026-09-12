package com.transsion.athena.hatnea;

import java.util.Arrays;
import java.util.List;

/* loaded from: classes5.dex */
public class ehatna {

    /* renamed from: a, reason: collision with root package name */
    public String f42832a;

    /* renamed from: b, reason: collision with root package name */
    public byte[] f42833b;

    /* renamed from: c, reason: collision with root package name */
    public int f42834c;

    /* renamed from: d, reason: collision with root package name */
    public List<Integer> f42835d;

    /* renamed from: e, reason: collision with root package name */
    public String f42836e;

    /* renamed from: f, reason: collision with root package name */
    public String f42837f;

    private ehatna(String str, byte[] bArr, int i11, List<Integer> list, String str2, String str3) {
        this.f42832a = str;
        this.f42833b = bArr;
        this.f42834c = i11;
        this.f42835d = list;
        this.f42836e = str2;
        this.f42837f = str3;
    }

    public static ehatna a(String str, byte[] bArr, int i11, List<Integer> list, String str2, String str3) {
        return new ehatna(str, bArr, i11, list, str2, str3);
    }

    public String toString() {
        return "UploadEventsRequest{host='" + this.f42832a + "', data=" + Arrays.toString(this.f42833b) + ", lineNumber=" + this.f42834c + ", appidList=" + this.f42835d + ", packetUid='" + this.f42836e + "', dupid='" + this.f42837f + "'}";
    }
}
