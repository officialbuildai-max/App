package go;

import androidx.collection.s;
import androidx.compose.foundation.e;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.player.p007enum.PlayMimeType;
import com.transsion.ugcvideodetail.api.bean.UGCVideo;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private final String f64014a;

    /* renamed from: b, reason: collision with root package name */
    private final PlayMimeType f64015b;

    /* renamed from: c, reason: collision with root package name */
    private long f64016c;

    /* renamed from: d, reason: collision with root package name */
    private final int f64017d;

    /* renamed from: e, reason: collision with root package name */
    private final int f64018e;

    /* renamed from: f, reason: collision with root package name */
    private final String f64019f;

    /* renamed from: g, reason: collision with root package name */
    private final String f64020g;

    /* renamed from: h, reason: collision with root package name */
    private final String f64021h;

    /* renamed from: i, reason: collision with root package name */
    private String f64022i;

    /* renamed from: j, reason: collision with root package name */
    private final List f64023j;

    /* renamed from: k, reason: collision with root package name */
    private final String f64024k;

    /* renamed from: l, reason: collision with root package name */
    private final String f64025l;

    /* renamed from: m, reason: collision with root package name */
    private final String f64026m;

    /* renamed from: n, reason: collision with root package name */
    private final int f64027n;

    /* renamed from: o, reason: collision with root package name */
    private final Integer f64028o;

    /* renamed from: p, reason: collision with root package name */
    private final boolean f64029p;

    /* renamed from: q, reason: collision with root package name */
    private final String f64030q;

    /* renamed from: r, reason: collision with root package name */
    private final String f64031r;

    /* renamed from: s, reason: collision with root package name */
    private UGCVideo f64032s;

    /* renamed from: t, reason: collision with root package name */
    private DownloadBean f64033t;

    /* renamed from: u, reason: collision with root package name */
    private Subject f64034u;

    /* renamed from: v, reason: collision with root package name */
    private final List f64035v;

    public a(String subjectId, PlayMimeType videoFormat, long j11, int i11, int i12, String subjectName, String str, String pageFrom, String pageName, List playSteams, String cover, String thumbnail, String averageHueLight, int i13, Integer num, boolean z10, String str2, String str3) {
        Intrinsics.h(subjectId, "subjectId");
        Intrinsics.h(videoFormat, "videoFormat");
        Intrinsics.h(subjectName, "subjectName");
        Intrinsics.h(pageFrom, "pageFrom");
        Intrinsics.h(pageName, "pageName");
        Intrinsics.h(playSteams, "playSteams");
        Intrinsics.h(cover, "cover");
        Intrinsics.h(thumbnail, "thumbnail");
        Intrinsics.h(averageHueLight, "averageHueLight");
        this.f64014a = subjectId;
        this.f64015b = videoFormat;
        this.f64016c = j11;
        this.f64017d = i11;
        this.f64018e = i12;
        this.f64019f = subjectName;
        this.f64020g = str;
        this.f64021h = pageFrom;
        this.f64022i = pageName;
        this.f64023j = playSteams;
        this.f64024k = cover;
        this.f64025l = thumbnail;
        this.f64026m = averageHueLight;
        this.f64027n = i13;
        this.f64028o = num;
        this.f64029p = z10;
        this.f64030q = str2;
        this.f64031r = str3;
        this.f64035v = new ArrayList();
    }

    public /* synthetic */ a(String str, PlayMimeType playMimeType, long j11, int i11, int i12, String str2, String str3, String str4, String str5, List list, String str6, String str7, String str8, int i13, Integer num, boolean z10, String str9, String str10, int i14, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, playMimeType, (i14 & 4) != 0 ? 0L : j11, (i14 & 8) != 0 ? 0 : i11, (i14 & 16) != 0 ? 0 : i12, str2, (i14 & 64) != 0 ? null : str3, str4, str5, (i14 & 512) != 0 ? new ArrayList() : list, str6, str7, str8, i13, (i14 & 16384) != 0 ? 1 : num, (32768 & i14) != 0 ? false : z10, str9, (i14 & 131072) != 0 ? null : str10);
    }

    public final void A(Subject subject) {
        this.f64034u = subject;
    }

    public final void B(UGCVideo uGCVideo) {
        this.f64032s = uGCVideo;
    }

    public final List a() {
        return this.f64035v;
    }

    public final String b() {
        return this.f64026m;
    }

    public final String c() {
        return this.f64024k;
    }

    public final DownloadBean d() {
        return this.f64033t;
    }

    public final int e() {
        return this.f64017d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return Intrinsics.c(this.f64014a, aVar.f64014a) && this.f64015b == aVar.f64015b && this.f64016c == aVar.f64016c && this.f64017d == aVar.f64017d && this.f64018e == aVar.f64018e && Intrinsics.c(this.f64019f, aVar.f64019f) && Intrinsics.c(this.f64020g, aVar.f64020g) && Intrinsics.c(this.f64021h, aVar.f64021h) && Intrinsics.c(this.f64022i, aVar.f64022i) && Intrinsics.c(this.f64023j, aVar.f64023j) && Intrinsics.c(this.f64024k, aVar.f64024k) && Intrinsics.c(this.f64025l, aVar.f64025l) && Intrinsics.c(this.f64026m, aVar.f64026m) && this.f64027n == aVar.f64027n && Intrinsics.c(this.f64028o, aVar.f64028o) && this.f64029p == aVar.f64029p && Intrinsics.c(this.f64030q, aVar.f64030q) && Intrinsics.c(this.f64031r, aVar.f64031r);
    }

    public final String f() {
        return this.f64020g;
    }

    public final boolean g() {
        return this.f64029p;
    }

    public final String h() {
        return this.f64021h;
    }

    public int hashCode() {
        int hashCode = ((((((((((this.f64014a.hashCode() * 31) + this.f64015b.hashCode()) * 31) + s.a(this.f64016c)) * 31) + this.f64017d) * 31) + this.f64018e) * 31) + this.f64019f.hashCode()) * 31;
        String str = this.f64020g;
        int hashCode2 = (((((((((((((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.f64021h.hashCode()) * 31) + this.f64022i.hashCode()) * 31) + this.f64023j.hashCode()) * 31) + this.f64024k.hashCode()) * 31) + this.f64025l.hashCode()) * 31) + this.f64026m.hashCode()) * 31) + this.f64027n) * 31;
        Integer num = this.f64028o;
        int hashCode3 = (((hashCode2 + (num == null ? 0 : num.hashCode())) * 31) + e.a(this.f64029p)) * 31;
        String str2 = this.f64030q;
        int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f64031r;
        return hashCode4 + (str3 != null ? str3.hashCode() : 0);
    }

    public final String i() {
        return this.f64022i;
    }

    public final List j() {
        return this.f64023j;
    }

    public final long k() {
        return this.f64016c;
    }

    public final int l() {
        return this.f64018e;
    }

    public final Subject m() {
        return this.f64034u;
    }

    public final int n() {
        return this.f64027n;
    }

    public final String o() {
        return this.f64014a;
    }

    public final String p() {
        return this.f64019f;
    }

    public final String q() {
        return this.f64031r;
    }

    public final Integer r() {
        return this.f64028o;
    }

    public final String s() {
        return this.f64025l;
    }

    public final String t() {
        return this.f64030q;
    }

    public String toString() {
        return "LongVdPlayerBean(subjectId=" + this.f64014a + ", videoFormat=" + this.f64015b + ", progress=" + this.f64016c + ", ep=" + this.f64017d + ", se=" + this.f64018e + ", subjectName=" + this.f64019f + ", episodeTitle=" + this.f64020g + ", pageFrom=" + this.f64021h + ", pageName=" + this.f64022i + ", playSteams=" + this.f64023j + ", cover=" + this.f64024k + ", thumbnail=" + this.f64025l + ", averageHueLight=" + this.f64026m + ", subjectDurationSeconds=" + this.f64027n + ", subjectType=" + this.f64028o + ", hasDelete=" + this.f64029p + ", titleName=" + this.f64030q + ", subjectOps=" + this.f64031r + ")";
    }

    public final UGCVideo u() {
        return this.f64032s;
    }

    public final PlayMimeType v() {
        return this.f64015b;
    }

    public final boolean w() {
        PlayMimeType playMimeType = this.f64015b;
        if (playMimeType != PlayMimeType.DEFAULT) {
            return playMimeType == PlayMimeType.HLS && this.f64023j.size() > 1;
        }
        return true;
    }

    public final void x(DownloadBean downloadBean) {
        this.f64033t = downloadBean;
    }

    public final void y(String str) {
        Intrinsics.h(str, "<set-?>");
        this.f64022i = str;
    }

    public final void z(long j11) {
        this.f64016c = j11;
    }
}
