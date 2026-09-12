package androidx.core.app;

import android.app.Person;
import android.os.Bundle;
import androidx.core.graphics.drawable.IconCompat;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import java.util.Objects;

/* loaded from: classes.dex */
public class w {

    /* renamed from: a, reason: collision with root package name */
    CharSequence f8188a;

    /* renamed from: b, reason: collision with root package name */
    IconCompat f8189b;

    /* renamed from: c, reason: collision with root package name */
    String f8190c;

    /* renamed from: d, reason: collision with root package name */
    String f8191d;

    /* renamed from: e, reason: collision with root package name */
    boolean f8192e;

    /* renamed from: f, reason: collision with root package name */
    boolean f8193f;

    /* loaded from: classes.dex */
    static class a {
        static w a(Person person) {
            return new b().f(person.getName()).c(person.getIcon() != null ? IconCompat.b(person.getIcon()) : null).g(person.getUri()).e(person.getKey()).b(person.isBot()).d(person.isImportant()).a();
        }

        static Person b(w wVar) {
            return new Person.Builder().setName(wVar.d()).setIcon(wVar.b() != null ? wVar.b().w() : null).setUri(wVar.e()).setKey(wVar.c()).setBot(wVar.f()).setImportant(wVar.g()).build();
        }
    }

    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        CharSequence f8194a;

        /* renamed from: b, reason: collision with root package name */
        IconCompat f8195b;

        /* renamed from: c, reason: collision with root package name */
        String f8196c;

        /* renamed from: d, reason: collision with root package name */
        String f8197d;

        /* renamed from: e, reason: collision with root package name */
        boolean f8198e;

        /* renamed from: f, reason: collision with root package name */
        boolean f8199f;

        public w a() {
            return new w(this);
        }

        public b b(boolean z10) {
            this.f8198e = z10;
            return this;
        }

        public b c(IconCompat iconCompat) {
            this.f8195b = iconCompat;
            return this;
        }

        public b d(boolean z10) {
            this.f8199f = z10;
            return this;
        }

        public b e(String str) {
            this.f8197d = str;
            return this;
        }

        public b f(CharSequence charSequence) {
            this.f8194a = charSequence;
            return this;
        }

        public b g(String str) {
            this.f8196c = str;
            return this;
        }
    }

    w(b bVar) {
        this.f8188a = bVar.f8194a;
        this.f8189b = bVar.f8195b;
        this.f8190c = bVar.f8196c;
        this.f8191d = bVar.f8197d;
        this.f8192e = bVar.f8198e;
        this.f8193f = bVar.f8199f;
    }

    public static w a(Person person) {
        return a.a(person);
    }

    public IconCompat b() {
        return this.f8189b;
    }

    public String c() {
        return this.f8191d;
    }

    public CharSequence d() {
        return this.f8188a;
    }

    public String e() {
        return this.f8190c;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof w)) {
            return false;
        }
        w wVar = (w) obj;
        String c11 = c();
        String c12 = wVar.c();
        return (c11 == null && c12 == null) ? Objects.equals(Objects.toString(d()), Objects.toString(wVar.d())) && Objects.equals(e(), wVar.e()) && Boolean.valueOf(f()).equals(Boolean.valueOf(wVar.f())) && Boolean.valueOf(g()).equals(Boolean.valueOf(wVar.g())) : Objects.equals(c11, c12);
    }

    public boolean f() {
        return this.f8192e;
    }

    public boolean g() {
        return this.f8193f;
    }

    public String h() {
        String str = this.f8190c;
        if (str != null) {
            return str;
        }
        if (this.f8188a == null) {
            return "";
        }
        return "name:" + ((Object) this.f8188a);
    }

    public int hashCode() {
        String c11 = c();
        return c11 != null ? c11.hashCode() : Objects.hash(d(), e(), Boolean.valueOf(f()), Boolean.valueOf(g()));
    }

    public Person i() {
        return a.b(this);
    }

    public Bundle j() {
        Bundle bundle = new Bundle();
        bundle.putCharSequence("name", this.f8188a);
        IconCompat iconCompat = this.f8189b;
        bundle.putBundle(RewardPlus.ICON, iconCompat != null ? iconCompat.v() : null);
        bundle.putString("uri", this.f8190c);
        bundle.putString("key", this.f8191d);
        bundle.putBoolean("isBot", this.f8192e);
        bundle.putBoolean("isImportant", this.f8193f);
        return bundle;
    }
}
