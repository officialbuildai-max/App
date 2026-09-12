package y00;

import java.io.File;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes7.dex */
public class d implements Iterator {

    /* renamed from: a, reason: collision with root package name */
    private File f78685a;

    /* renamed from: b, reason: collision with root package name */
    private String[] f78686b;

    /* renamed from: c, reason: collision with root package name */
    private int f78687c;

    public d() {
        this.f78687c = 0;
    }

    public d(File file) {
        this.f78687c = 0;
        this.f78685a = file;
    }

    public d(File file, String[] strArr) {
        this(file);
        a(strArr);
    }

    public void a(String[] strArr) {
        String[] strArr2 = this.f78686b;
        int length = strArr2 == null ? 0 : strArr2.length;
        String[] strArr3 = new String[strArr.length + length];
        if (length > 0) {
            System.arraycopy(strArr2, 0, strArr3, 0, length);
        }
        this.f78686b = strArr3;
        System.arraycopy(strArr, 0, strArr3, length, strArr.length);
    }

    public c b() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        File file = this.f78685a;
        String[] strArr = this.f78686b;
        int i11 = this.f78687c;
        this.f78687c = i11 + 1;
        return new c(file, strArr[i11]);
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f78687c < this.f78686b.length;
    }

    @Override // java.util.Iterator
    public Object next() {
        return b();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
