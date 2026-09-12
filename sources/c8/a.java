package c8;

import java.io.File;

/* loaded from: classes3.dex */
public class a implements f8.a {

    /* renamed from: a, reason: collision with root package name */
    private f8.b f17101a;

    public a(f8.b bVar) {
        this.f17101a = bVar;
    }

    @Override // f8.a
    public int a() {
        return 1;
    }

    @Override // f8.b
    public boolean b(File file) {
        return this.f17101a.b(file);
    }

    @Override // f8.a
    public String c(String str, int i11) {
        return str + ".bak";
    }
}
