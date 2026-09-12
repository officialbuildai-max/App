package s00;

import java.io.FilterReader;
import java.io.StringReader;
import org.apache.tools.ant.Project;
import org.apache.tools.ant.util.d;

/* loaded from: classes7.dex */
public abstract class a extends FilterReader {

    /* renamed from: a, reason: collision with root package name */
    private boolean f74975a;

    /* renamed from: b, reason: collision with root package name */
    private Project f74976b;

    public a() {
        super(new StringReader(""));
        this.f74975a = false;
        this.f74976b = null;
        d.d(this);
    }

    public final void b(Project project) {
        this.f74976b = project;
    }

    @Override // java.io.FilterReader, java.io.Reader
    public final int read(char[] cArr, int i11, int i12) {
        for (int i13 = 0; i13 < i12; i13++) {
            int read = read();
            if (read == -1) {
                if (i13 == 0) {
                    return -1;
                }
                return i13;
            }
            cArr[i11 + i13] = (char) read;
        }
        return i12;
    }

    @Override // java.io.FilterReader, java.io.Reader
    public final long skip(long j11) {
        if (j11 < 0) {
            throw new IllegalArgumentException("skip value is negative");
        }
        for (long j12 = 0; j12 < j11; j12++) {
            if (read() == -1) {
                return j12;
            }
        }
        return j11;
    }
}
