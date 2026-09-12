package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    protected int f9167a;

    /* renamed from: b, reason: collision with root package name */
    protected ByteBuffer f9168b;

    /* renamed from: c, reason: collision with root package name */
    private int f9169c;

    /* renamed from: d, reason: collision with root package name */
    private int f9170d;

    /* renamed from: e, reason: collision with root package name */
    f f9171e = f.a();

    /* JADX INFO: Access modifiers changed from: protected */
    public int a(int i11) {
        return i11 + this.f9168b.getInt(i11);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int b(int i11) {
        if (i11 < this.f9170d) {
            return this.f9168b.getShort(this.f9169c + i11);
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(int i11, ByteBuffer byteBuffer) {
        this.f9168b = byteBuffer;
        if (byteBuffer == null) {
            this.f9167a = 0;
            this.f9169c = 0;
            this.f9170d = 0;
        } else {
            this.f9167a = i11;
            int i12 = i11 - byteBuffer.getInt(i11);
            this.f9169c = i12;
            this.f9170d = this.f9168b.getShort(i12);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int d(int i11) {
        int i12 = i11 + this.f9167a;
        return i12 + this.f9168b.getInt(i12) + 4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int e(int i11) {
        int i12 = i11 + this.f9167a;
        return this.f9168b.getInt(i12 + this.f9168b.getInt(i12));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int f(Integer num, Integer num2, ByteBuffer byteBuffer) {
        return 0;
    }
}
