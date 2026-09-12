package androidx.core.app;

import android.app.RemoteInput;
import android.os.Build;
import android.os.Bundle;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes.dex */
public final class y {

    /* renamed from: a, reason: collision with root package name */
    private final String f8202a;

    /* renamed from: b, reason: collision with root package name */
    private final CharSequence f8203b;

    /* renamed from: c, reason: collision with root package name */
    private final CharSequence[] f8204c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f8205d;

    /* renamed from: e, reason: collision with root package name */
    private final int f8206e;

    /* renamed from: f, reason: collision with root package name */
    private final Bundle f8207f;

    /* renamed from: g, reason: collision with root package name */
    private final Set f8208g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        public static RemoteInput a(y yVar) {
            Set d11;
            RemoteInput.Builder addExtras = new RemoteInput.Builder(yVar.i()).setLabel(yVar.h()).setChoices(yVar.e()).setAllowFreeFormInput(yVar.c()).addExtras(yVar.g());
            if (Build.VERSION.SDK_INT >= 26 && (d11 = yVar.d()) != null) {
                Iterator it = d11.iterator();
                while (it.hasNext()) {
                    b.a(addExtras, (String) it.next(), true);
                }
            }
            if (Build.VERSION.SDK_INT >= 29) {
                c.a(addExtras, yVar.f());
            }
            return addExtras.build();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class b {
        static RemoteInput.Builder a(RemoteInput.Builder builder, String str, boolean z10) {
            return builder.setAllowDataType(str, z10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class c {
        static RemoteInput.Builder a(RemoteInput.Builder builder, int i11) {
            return builder.setEditChoicesBeforeSending(i11);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(String str, CharSequence charSequence, CharSequence[] charSequenceArr, boolean z10, int i11, Bundle bundle, Set set) {
        this.f8202a = str;
        this.f8203b = charSequence;
        this.f8204c = charSequenceArr;
        this.f8205d = z10;
        this.f8206e = i11;
        this.f8207f = bundle;
        this.f8208g = set;
        if (f() == 2 && !c()) {
            throw new IllegalArgumentException("setEditChoicesBeforeSending requires setAllowFreeFormInput");
        }
    }

    static RemoteInput a(y yVar) {
        return a.a(yVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static RemoteInput[] b(y[] yVarArr) {
        if (yVarArr == null) {
            return null;
        }
        RemoteInput[] remoteInputArr = new RemoteInput[yVarArr.length];
        for (int i11 = 0; i11 < yVarArr.length; i11++) {
            remoteInputArr[i11] = a(yVarArr[i11]);
        }
        return remoteInputArr;
    }

    public boolean c() {
        return this.f8205d;
    }

    public Set d() {
        return this.f8208g;
    }

    public CharSequence[] e() {
        return this.f8204c;
    }

    public int f() {
        return this.f8206e;
    }

    public Bundle g() {
        return this.f8207f;
    }

    public CharSequence h() {
        return this.f8203b;
    }

    public String i() {
        return this.f8202a;
    }

    public boolean j() {
        return (c() || (e() != null && e().length != 0) || d() == null || d().isEmpty()) ? false : true;
    }
}
