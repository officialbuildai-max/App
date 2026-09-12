package jn;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.y;
import com.transsion.mb.config.manager.ConfigBean;
import com.transsion.moviedetailapi.bean.FirstFrame;
import com.transsion.moviedetailapi.bean.Media;
import com.transsion.moviedetailapi.bean.MediaType;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.moviedetailapi.bean.Video;
import com.transsion.player.orplayer.ORPlayerPreloadManager;
import ej.f;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import lg.a;
import nh.m;

/* loaded from: classes6.dex */
public final class b extends RecyclerView.r {

    /* renamed from: e, reason: collision with root package name */
    public static final a f66360e = new a(null);

    /* renamed from: f, reason: collision with root package name */
    private static final Lazy f66361f = LazyKt.b(new Function0() { // from class: jn.a
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            int j11;
            j11 = b.j();
            return Integer.valueOf(j11);
        }
    });

    /* renamed from: a, reason: collision with root package name */
    private final float f66362a;

    /* renamed from: b, reason: collision with root package name */
    private final Function1 f66363b;

    /* renamed from: c, reason: collision with root package name */
    private final String f66364c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f66365d;

    /* loaded from: classes6.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return ((Number) b.f66361f.getValue()).intValue();
        }
    }

    public b(float f11, Function1 getItemCallback) {
        String value;
        Boolean m12;
        Intrinsics.h(getItemCallback, "getItemCallback");
        this.f66362a = f11;
        this.f66363b = getItemCallback;
        this.f66364c = "ListVideoPreload";
        boolean z10 = false;
        ConfigBean c11 = sm.f.f75530c.a().c("feed_video_preload_switch", false);
        if (c11 != null && (value = c11.getValue()) != null && (m12 = StringsKt.m1(value)) != null) {
            z10 = m12.booleanValue();
        }
        this.f66365d = z10;
    }

    private final float f(View view) {
        if (view == null) {
            return 0.0f;
        }
        int height = view.getHeight();
        if (view.getGlobalVisibleRect(new Rect())) {
            return (float) ((r2.height() * 1.0d) / height);
        }
        return 0.0f;
    }

    private final Video g(List list) {
        Object obj = null;
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Video video = (Video) it.next();
                Integer definition = video.getDefinition();
                if (definition != null && definition.intValue() == 3) {
                    obj = video;
                }
            }
        }
        if (obj == null && list != null && (!list.isEmpty())) {
            obj = list.get(0);
        }
        return (Video) obj;
    }

    private final void h(PostSubjectItem postSubjectItem) {
        FirstFrame firstFrame;
        String url;
        Media media = postSubjectItem.getMedia();
        if (media == null || (firstFrame = media.getFirstFrame()) == null || (url = firstFrame.getUrl()) == null) {
            return;
        }
        f.a aVar = ej.f.f62005a;
        a aVar2 = f66360e;
        f.a.j(aVar, f.a.e(aVar, url, aVar2.a(), false, true, 4, null), url, aVar2.a(), null, 8, null);
    }

    private final void i(PostSubjectItem postSubjectItem) {
        String url;
        Media media = postSubjectItem.getMedia();
        Video g11 = g(media != null ? media.getVideo() : null);
        if (g11 == null || (url = g11.getUrl()) == null) {
            return;
        }
        ORPlayerPreloadManager.f48463i.a().i(url);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int j() {
        return y.e();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.r
    public void onScrollStateChanged(RecyclerView recyclerView, int i11) {
        int findFirstVisibleItemPosition;
        int findLastVisibleItemPosition;
        String str;
        Media media;
        Intrinsics.h(recyclerView, "recyclerView");
        super.onScrollStateChanged(recyclerView, i11);
        if (i11 != 0 || !this.f66365d || !m.f70597a.e()) {
            return;
        }
        RecyclerView.m layoutManager = recyclerView.getLayoutManager();
        LinearLayoutManager linearLayoutManager = layoutManager instanceof LinearLayoutManager ? (LinearLayoutManager) layoutManager : null;
        if (linearLayoutManager == null || (findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition()) > (findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition())) {
            return;
        }
        int i12 = findFirstVisibleItemPosition;
        while (true) {
            a.C0856a c0856a = lg.a.f68962a;
            a.C0856a.f(c0856a, this.f66364c, "on scroll idle, firstPosition = " + findFirstVisibleItemPosition + ", lastPosition = " + findLastVisibleItemPosition + ", position = " + i12, false, 4, null);
            try {
                PostSubjectItem postSubjectItem = (PostSubjectItem) this.f66363b.invoke(Integer.valueOf(i12));
                if (Intrinsics.c((postSubjectItem == null || (media = postSubjectItem.getMedia()) == null) ? null : media.getMediaType(), MediaType.VIDEO.getValue()) && !postSubjectItem.getBuiltIn()) {
                    View findViewByPosition = linearLayoutManager.findViewByPosition(i12);
                    float f11 = f(findViewByPosition);
                    float f12 = this.f66362a;
                    if (f12 > 0.6f) {
                        f12 = 0.6f;
                    }
                    if (f11 >= f12) {
                        String str2 = this.f66364c;
                        Subject subject = postSubjectItem.getSubject();
                        str = "tryPreloadVideo, position = ";
                        a.C0856a.f(c0856a, str2, "tryPreloadVideo, position = " + i12 + ", title = " + (subject != null ? subject.getTitle() : null), false, 4, null);
                        h(postSubjectItem);
                    } else {
                        str = "tryPreloadVideo, position = ";
                    }
                    if (f(findViewByPosition) >= this.f66362a) {
                        String str3 = this.f66364c;
                        Subject subject2 = postSubjectItem.getSubject();
                        a.C0856a.f(c0856a, str3, str + i12 + ", title = " + (subject2 != null ? subject2.getTitle() : null), false, 4, null);
                        i(postSubjectItem);
                    }
                }
            } catch (Throwable unused) {
            }
            if (i12 == findLastVisibleItemPosition) {
                return;
            } else {
                i12++;
            }
        }
    }
}
