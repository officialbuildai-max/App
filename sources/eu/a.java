package eu;

import com.transsion.subtitle_download.db.SubtitleDownloadTable;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes7.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private SubtitleDownloadTable f62133a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f62134b;

    /* renamed from: c, reason: collision with root package name */
    private String f62135c;

    /* renamed from: d, reason: collision with root package name */
    private String f62136d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f62137e;

    /* renamed from: f, reason: collision with root package name */
    private String f62138f;

    public a(SubtitleDownloadTable bean) {
        Intrinsics.h(bean, "bean");
        this.f62133a = bean;
        this.f62135c = "";
        this.f62138f = "";
    }

    public final String a() {
        return this.f62138f;
    }

    public final SubtitleDownloadTable b() {
        return this.f62133a;
    }

    public final String c() {
        return this.f62136d;
    }

    public final boolean d() {
        return this.f62133a.getStatus() == 5;
    }

    public final boolean e() {
        return this.f62137e;
    }

    public final boolean f() {
        return this.f62134b;
    }

    public final void g(String str) {
        Intrinsics.h(str, "<set-?>");
        this.f62138f = str;
    }

    public final void h(SubtitleDownloadTable subtitleDownloadTable) {
        Intrinsics.h(subtitleDownloadTable, "<set-?>");
        this.f62133a = subtitleDownloadTable;
    }

    public final void i(String str) {
        this.f62136d = str;
    }

    public final void j(boolean z10) {
        this.f62137e = z10;
    }

    public final void k(String str) {
        Intrinsics.h(str, "<set-?>");
        this.f62135c = str;
    }

    public final void l(boolean z10) {
        this.f62134b = z10;
    }
}
