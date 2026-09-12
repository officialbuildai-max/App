package w2;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/* loaded from: classes2.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private final ByteArrayOutputStream f77682a;

    /* renamed from: b, reason: collision with root package name */
    private final DataOutputStream f77683b;

    public c() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(512);
        this.f77682a = byteArrayOutputStream;
        this.f77683b = new DataOutputStream(byteArrayOutputStream);
    }

    private static void b(DataOutputStream dataOutputStream, String str) {
        dataOutputStream.writeBytes(str);
        dataOutputStream.writeByte(0);
    }

    public byte[] a(a aVar) {
        this.f77682a.reset();
        try {
            b(this.f77683b, aVar.f77676a);
            String str = aVar.f77677b;
            if (str == null) {
                str = "";
            }
            b(this.f77683b, str);
            this.f77683b.writeLong(aVar.f77678c);
            this.f77683b.writeLong(aVar.f77679d);
            this.f77683b.write(aVar.f77680e);
            this.f77683b.flush();
            return this.f77682a.toByteArray();
        } catch (IOException e11) {
            throw new RuntimeException(e11);
        }
    }
}
