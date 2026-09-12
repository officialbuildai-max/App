package tz;

import java.io.InputStream;

/* loaded from: classes7.dex */
public class b implements Comparable {

    /* renamed from: a, reason: collision with root package name */
    private int f76554a;

    /* renamed from: b, reason: collision with root package name */
    private byte[] f76555b;

    /* renamed from: c, reason: collision with root package name */
    private int f76556c;

    /* renamed from: d, reason: collision with root package name */
    private InputStream f76557d;

    /* renamed from: e, reason: collision with root package name */
    private String f76558e;

    /* renamed from: f, reason: collision with root package name */
    private String f76559f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, h hVar, int i11) {
        this.f76555b = null;
        this.f76557d = null;
        this.f76554a = i11;
        InputStream inputStream = aVar.f76549g;
        if (inputStream == null) {
            this.f76555b = aVar.f76547e;
            this.f76556c = aVar.f76548f;
        }
        this.f76557d = inputStream;
        this.f76558e = hVar.b();
        this.f76559f = hVar.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, h hVar, int i11, String str, String str2) {
        this.f76555b = null;
        this.f76557d = null;
        this.f76554a = i11;
        InputStream inputStream = aVar.f76549g;
        if (inputStream == null) {
            this.f76555b = aVar.f76547e;
            this.f76556c = aVar.f76548f;
        }
        this.f76557d = inputStream;
        this.f76558e = str;
        this.f76559f = str2;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(b bVar) {
        int i11 = this.f76554a;
        int i12 = bVar.f76554a;
        if (i11 > i12) {
            return 1;
        }
        return i11 < i12 ? -1 : 0;
    }

    public String getName() {
        return this.f76558e;
    }
}
