package e8;

import android.util.Log;

/* loaded from: classes4.dex */
public class a implements c {

    /* renamed from: a, reason: collision with root package name */
    private boolean f61726a;

    /* renamed from: b, reason: collision with root package name */
    private int f61727b;

    public a() {
        this(false, 4000);
    }

    public a(boolean z10, int i11) {
        this.f61726a = z10;
        this.f61727b = i11;
    }

    static int b(String str, int i11, int i12) {
        if (i12 == str.length() || str.charAt(i12) == '\n') {
            return i12;
        }
        for (int i13 = i12 - 1; i11 < i13; i13--) {
            if (str.charAt(i13) == '\n') {
                return i13;
            }
        }
        return i12;
    }

    @Override // e8.c
    public void a(int i11, String str, String str2) {
        int length = str2.length();
        int i12 = 0;
        while (i12 < length) {
            if (str2.charAt(i12) == '\n') {
                i12++;
            } else {
                int min = Math.min(this.f61727b + i12, length);
                if (this.f61726a) {
                    int indexOf = str2.indexOf(10, i12);
                    if (indexOf != -1) {
                        min = indexOf;
                    }
                } else {
                    min = b(str2, i12, min);
                }
                c(i11, str, str2.substring(i12, min));
                i12 = min;
            }
        }
    }

    void c(int i11, String str, String str2) {
        Log.println(i11, str, str2);
    }
}
