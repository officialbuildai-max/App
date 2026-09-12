package cv;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

/* loaded from: classes7.dex */
public class g extends e {

    /* renamed from: d, reason: collision with root package name */
    String f61046d;

    public g(String str, String str2) {
        super(str, str2.getBytes().length, null);
        this.f61046d = str2;
    }

    @Override // cv.e
    protected InputStream e() {
        return new ByteArrayInputStream(this.f61046d.getBytes());
    }

    public String toString() {
        return this.f61046d;
    }
}
