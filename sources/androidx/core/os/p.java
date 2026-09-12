package androidx.core.os;

import android.os.LocaleList;
import java.util.Locale;

/* loaded from: classes.dex */
final class p implements k {

    /* renamed from: a, reason: collision with root package name */
    private final LocaleList f8253a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(Object obj) {
        this.f8253a = o.a(obj);
    }

    @Override // androidx.core.os.k
    public String a() {
        String languageTags;
        languageTags = this.f8253a.toLanguageTags();
        return languageTags;
    }

    @Override // androidx.core.os.k
    public Object b() {
        return this.f8253a;
    }

    public boolean equals(Object obj) {
        boolean equals;
        equals = this.f8253a.equals(((k) obj).b());
        return equals;
    }

    @Override // androidx.core.os.k
    public Locale get(int i11) {
        Locale locale;
        locale = this.f8253a.get(i11);
        return locale;
    }

    public int hashCode() {
        int hashCode;
        hashCode = this.f8253a.hashCode();
        return hashCode;
    }

    @Override // androidx.core.os.k
    public boolean isEmpty() {
        boolean isEmpty;
        isEmpty = this.f8253a.isEmpty();
        return isEmpty;
    }

    @Override // androidx.core.os.k
    public int size() {
        int size;
        size = this.f8253a.size();
        return size;
    }

    public String toString() {
        String localeList;
        localeList = this.f8253a.toString();
        return localeList;
    }
}
