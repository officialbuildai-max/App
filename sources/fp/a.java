package fp;

import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.publish.api.AudioEntity;
import com.transsion.publish.api.GroupBean;
import com.transsion.publish.api.LinkEntity;
import com.transsion.publish.api.PhotoEntity;
import com.transsion.publish.api.VsMediaInfo;
import com.transsion.room.api.bean.LocationPlace;
import java.util.List;
import jn.e;

/* loaded from: classes6.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private Integer f62568a = 0;

    /* renamed from: b, reason: collision with root package name */
    private Integer f62569b = 0;

    /* renamed from: c, reason: collision with root package name */
    private List f62570c;

    /* renamed from: d, reason: collision with root package name */
    private AudioEntity f62571d;

    /* renamed from: e, reason: collision with root package name */
    private VsMediaInfo f62572e;

    /* renamed from: f, reason: collision with root package name */
    private LinkEntity f62573f;

    /* renamed from: g, reason: collision with root package name */
    private PhotoEntity f62574g;

    /* renamed from: h, reason: collision with root package name */
    private Subject f62575h;

    /* renamed from: i, reason: collision with root package name */
    private GroupBean f62576i;

    /* renamed from: j, reason: collision with root package name */
    private LocationPlace f62577j;

    public final AudioEntity a() {
        return this.f62571d;
    }

    public final PhotoEntity b() {
        return this.f62574g;
    }

    public final GroupBean c() {
        return this.f62576i;
    }

    public final Integer d() {
        return this.f62569b;
    }

    public final Integer e() {
        return this.f62568a;
    }

    public final LinkEntity f() {
        return this.f62573f;
    }

    public final LocationPlace g() {
        return this.f62577j;
    }

    public final List h() {
        return this.f62570c;
    }

    public final Subject i() {
        return this.f62575h;
    }

    public final VsMediaInfo j() {
        return this.f62572e;
    }

    public final void k(AudioEntity audioEntity) {
        this.f62571d = audioEntity;
    }

    public final void l(PhotoEntity photoEntity) {
        this.f62574g = photoEntity;
    }

    public final void m(GroupBean groupBean) {
        this.f62576i = groupBean;
    }

    public final void n(Integer num) {
        this.f62569b = num;
    }

    public final void o(Integer num) {
        this.f62568a = num;
    }

    public final void p(LinkEntity linkEntity) {
        this.f62573f = linkEntity;
    }

    public final void q(LocationPlace locationPlace) {
        this.f62577j = locationPlace;
    }

    public final void r(List list) {
        this.f62570c = list;
    }

    public final void s(Subject subject) {
        this.f62575h = subject;
    }

    public final a t(String str, Integer num, String str2, String str3, String str4) {
        this.f62575h = new Subject(str, num, str2, null, new Cover(null, null, null, str3, null, str4, null, null, null, 471, null), null, null, null, null, e.f66368a.g(num), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, false, null, null, null, null, null, false, false, null, null, 0, false, false, 0L, null, null, 0L, null, 0, false, null, 0, null, null, null, null, null, 0, null, null, null, null, null, null, -536, 134217727, null);
        return this;
    }

    public final void u(VsMediaInfo vsMediaInfo) {
        this.f62572e = vsMediaInfo;
    }
}
