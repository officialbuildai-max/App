package bp;

import android.content.Context;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.view.LifecycleCoroutineScope;
import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.google.android.material.imageview.ShapeableImageView;
import com.tn.lib.widget.R$drawable;
import com.transsion.moviedetailapi.bean.FirstFrame;
import com.transsion.moviedetailapi.bean.Image;
import com.transsion.moviedetailapi.bean.Media;
import com.transsion.moviedetailapi.bean.MediaType;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import com.transsion.moviedetailapi.bean.Stat;
import com.transsion.moviedetailapi.bean.User;
import com.transsion.postdetail.R$id;
import com.transsion.postdetail.R$layout;
import com.transsion.postdetail.helper.NegativeFeedbackHelper;
import ej.f;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class z extends BaseItemProvider {

    /* renamed from: e, reason: collision with root package name */
    private final String f16783e;

    /* renamed from: f, reason: collision with root package name */
    private final String f16784f;

    /* renamed from: g, reason: collision with root package name */
    private final RecyclerView.s f16785g;

    /* renamed from: h, reason: collision with root package name */
    private final Context f16786h;

    /* renamed from: i, reason: collision with root package name */
    private final LifecycleCoroutineScope f16787i;

    /* renamed from: j, reason: collision with root package name */
    private final int f16788j;

    public z(String str, String str2, RecyclerView.s pool, Context context, LifecycleCoroutineScope lifecycleCoroutineScope) {
        Intrinsics.h(pool, "pool");
        this.f16783e = str;
        this.f16784f = str2;
        this.f16785g = pool;
        this.f16786h = context;
        this.f16787i = lifecycleCoroutineScope;
        this.f16788j = (com.blankj.utilcode.util.y.e() - (com.blankj.utilcode.util.a0.a(6.0f) * 3)) / 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean C(final PostSubjectItem postSubjectItem, final z zVar, View view) {
        LifecycleCoroutineScope lifecycleCoroutineScope;
        String userId;
        String postId = postSubjectItem.getPostId();
        if (postId == null) {
            return false;
        }
        User user = postSubjectItem.getUser();
        String str = (user == null || (userId = user.getUserId()) == null) ? "" : userId;
        Context context = zVar.f16786h;
        if (context == null || (lifecycleCoroutineScope = zVar.f16787i) == null) {
            return false;
        }
        com.transsion.postdetail.helper.a aVar = com.transsion.postdetail.helper.a.f48920a;
        String str2 = zVar.f16783e;
        if (str2 == null) {
            str2 = "";
        }
        aVar.l(postSubjectItem, str2, zVar.f16784f);
        NegativeFeedbackHelper negativeFeedbackHelper = NegativeFeedbackHelper.f48903a;
        String str3 = zVar.f16783e;
        if (str3 == null) {
            str3 = "";
        }
        negativeFeedbackHelper.k(postId, str, context, lifecycleCoroutineScope, str3, new Function0() { // from class: bp.y
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit D;
                D = z.D(z.this, postSubjectItem);
                return D;
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit D(z zVar, PostSubjectItem postSubjectItem) {
        int indexOf;
        BaseProviderMultiAdapter g11 = zVar.g();
        if (g11 != null && (indexOf = g11.getData().indexOf(postSubjectItem)) >= 0) {
            g11.C0(indexOf);
        }
        return Unit.f67184a;
    }

    private final int E(int i11, int i12, int i13) {
        float f11 = i11 / i12;
        return f11 < 0.75f ? (i13 * 4) / 3 : f11 > 1.3333334f ? (i13 * 3) / 4 : (int) (i13 / f11);
    }

    private final void G(BaseViewHolder baseViewHolder, PostSubjectItem postSubjectItem, boolean z10) {
        F((AppCompatTextView) baseViewHolder.getViewOrNull(R$id.tv_staggered_post_like), z10, postSubjectItem);
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder helper, final PostSubjectItem item) {
        String title;
        String str;
        String str2;
        Integer height;
        Integer width;
        List<Image> image;
        List<Image> image2;
        String str3;
        String str4;
        Integer height2;
        Integer width2;
        Intrinsics.h(helper, "helper");
        Intrinsics.h(item, "item");
        String content = item.getContent();
        String str5 = "";
        if (content == null || content.length() == 0 ? (title = item.getTitle()) == null : (title = item.getContent()) == null) {
            title = "";
        }
        AppCompatTextView appCompatTextView = (AppCompatTextView) helper.getViewOrNull(R$id.tvPicNum);
        AppCompatImageView appCompatImageView = (AppCompatImageView) helper.getViewOrNull(R$id.ivPlaying);
        ShapeableImageView shapeableImageView = (ShapeableImageView) helper.getViewOrNull(R$id.iv_cover);
        Media media = item.getMedia();
        if (Intrinsics.c(media != null ? media.getMediaType() : null, MediaType.VIDEO.getValue())) {
            if (appCompatImageView != null) {
                jg.c.k(appCompatImageView);
            }
            if (appCompatTextView != null) {
                jg.c.g(appCompatTextView);
            }
            Media media2 = item.getMedia();
            FirstFrame firstFrame = media2 != null ? media2.getFirstFrame() : null;
            if (shapeableImageView != null) {
                shapeableImageView.getLayoutParams().height = E((firstFrame == null || (width2 = firstFrame.getWidth()) == null) ? 0 : width2.intValue(), (firstFrame == null || (height2 = firstFrame.getHeight()) == null) ? 0 : height2.intValue(), this.f16788j);
                f.a aVar = ej.f.f62005a;
                Context context = shapeableImageView.getContext();
                Intrinsics.g(context, "getContext(...)");
                f.b m11 = aVar.m(context);
                if (firstFrame == null || (str4 = firstFrame.getUrl()) == null) {
                    str4 = "";
                }
                m11.g(str4).d(shapeableImageView);
            }
        } else {
            if (appCompatImageView != null) {
                jg.c.g(appCompatImageView);
            }
            Media media3 = item.getMedia();
            List<Image> image3 = media3 != null ? media3.getImage() : null;
            if (image3 != null && !image3.isEmpty()) {
                Media media4 = item.getMedia();
                Image image4 = (media4 == null || (image2 = media4.getImage()) == null) ? null : image2.get(0);
                Media media5 = item.getMedia();
                int size = (media5 == null || (image = media5.getImage()) == null) ? 0 : image.size();
                if (shapeableImageView != null) {
                    shapeableImageView.getLayoutParams().height = E((image4 == null || (width = image4.getWidth()) == null) ? 0 : width.intValue(), (image4 == null || (height = image4.getHeight()) == null) ? 0 : height.intValue(), this.f16788j);
                    f.a aVar2 = ej.f.f62005a;
                    Context context2 = shapeableImageView.getContext();
                    Intrinsics.g(context2, "getContext(...)");
                    f.b m12 = aVar2.m(context2);
                    if (image4 == null || (str = image4.getUrl()) == null) {
                        str = "";
                    }
                    f.b g11 = m12.g(str);
                    if (image4 == null || (str2 = image4.getThumbnail()) == null) {
                        str2 = "";
                    }
                    g11.l(str2).d(shapeableImageView);
                }
                if (size > 1) {
                    if (appCompatTextView != null) {
                        jg.c.k(appCompatTextView);
                    }
                    if (appCompatTextView != null) {
                        appCompatTextView.setText(size + " pics");
                    }
                } else if (appCompatTextView != null) {
                    jg.c.g(appCompatTextView);
                }
            }
        }
        AppCompatTextView appCompatTextView2 = (AppCompatTextView) helper.getViewOrNull(R$id.tv_title);
        if (title.length() == 0) {
            if (appCompatTextView2 != null) {
                jg.c.g(appCompatTextView2);
            }
        } else if (appCompatTextView2 != null) {
            jg.c.k(appCompatTextView2);
        }
        if (appCompatTextView2 != null) {
            appCompatTextView2.setText(title);
        }
        ShapeableImageView shapeableImageView2 = (ShapeableImageView) helper.getViewOrNull(R$id.iv_user_avatar);
        if (shapeableImageView2 != null) {
            f.a aVar3 = ej.f.f62005a;
            Context context3 = shapeableImageView2.getContext();
            Intrinsics.g(context3, "getContext(...)");
            f.b m13 = aVar3.m(context3);
            User user = item.getUser();
            if (user == null || (str3 = user.getAvatar()) == null) {
                str3 = "";
            }
            m13.g(str3).d(shapeableImageView2);
        }
        int i11 = R$id.tv_user_name;
        User user2 = item.getUser();
        helper.setText(i11, user2 != null ? user2.getNickname() : null);
        AppCompatTextView appCompatTextView3 = (AppCompatTextView) helper.getViewOrNull(R$id.tv_staggered_post_like);
        if (appCompatTextView3 != null) {
            Stat stat = item.getStat();
            Long likeCount = stat != null ? stat.getLikeCount() : null;
            if (likeCount != null && likeCount.longValue() != 0) {
                str5 = com.transsion.baseui.util.j.a(likeCount.longValue());
            }
            appCompatTextView3.setText(str5);
            if (Intrinsics.c(item.getHasLike(), Boolean.TRUE)) {
                appCompatTextView3.setCompoundDrawablesWithIntrinsicBounds(R$drawable.room_staggered_like_icon, 0, 0, 0);
            } else {
                appCompatTextView3.setCompoundDrawablesWithIntrinsicBounds(R$drawable.room_staggered_unlike_icon, 0, 0, 0);
            }
        }
        helper.itemView.setOnLongClickListener(new View.OnLongClickListener() { // from class: bp.x
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                boolean C;
                C = z.C(PostSubjectItem.this, this, view);
                return C;
            }
        });
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public void f(BaseViewHolder helper, PostSubjectItem item, List payloads) {
        List<Object> data;
        Intrinsics.h(helper, "helper");
        Intrinsics.h(item, "item");
        Intrinsics.h(payloads, "payloads");
        super.f(helper, item, payloads);
        if (payloads.isEmpty()) {
            return;
        }
        Object v02 = CollectionsKt.v0(payloads);
        if (v02 instanceof Boolean) {
            try {
                Result.Companion companion = Result.INSTANCE;
                BaseProviderMultiAdapter g11 = g();
                if (g11 != null && (data = g11.getData()) != null) {
                    int adapterPosition = helper.getAdapterPosition();
                    BaseProviderMultiAdapter g12 = g();
                    PostSubjectItem postSubjectItem = (PostSubjectItem) data.get(adapterPosition + (g12 != null ? g12.a0() : 0));
                    if (postSubjectItem != null) {
                        G(helper, postSubjectItem, ((Boolean) v02).booleanValue());
                    }
                }
                Result.m1185constructorimpl(Unit.f67184a);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.m1185constructorimpl(ResultKt.a(th2));
            }
        }
    }

    public final void F(AppCompatTextView appCompatTextView, boolean z10, PostSubjectItem item) {
        Intrinsics.h(item, "item");
        if (appCompatTextView != null) {
            Stat stat = item.getStat();
            Long likeCount = stat != null ? stat.getLikeCount() : null;
            appCompatTextView.setText((likeCount == null || likeCount.longValue() == 0) ? "" : com.transsion.baseui.util.j.a(likeCount.longValue()));
            if (z10) {
                appCompatTextView.setCompoundDrawablesWithIntrinsicBounds(R$drawable.room_staggered_like_icon, 0, 0, 0);
            } else {
                appCompatTextView.setCompoundDrawablesWithIntrinsicBounds(R$drawable.room_staggered_unlike_icon, 0, 0, 0);
            }
        }
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int l() {
        return MediaType.CONTENT_ALL.ordinal();
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int m() {
        return R$layout.item_provider_post_staggered_layout;
    }
}
