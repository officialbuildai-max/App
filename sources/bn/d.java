package bn;

import android.view.View;
import android.widget.FrameLayout;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.therouter.TheRouter;
import com.transsion.moviedetail.R$id;
import com.transsion.moviedetail.R$layout;
import com.transsion.moviedetailapi.bean.MediaType;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import com.transsion.moviedetailapi.bean.RoomItem;
import com.transsion.moviedetailapi.p006enum.ProfileSubSource;
import com.transsion.room.api.IRoomApi;
import com.transsion.room.api.RoomsViewType;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class d extends BaseItemProvider {

    /* renamed from: e, reason: collision with root package name */
    private final String f16712e;

    /* renamed from: f, reason: collision with root package name */
    private final String f16713f;

    /* renamed from: g, reason: collision with root package name */
    private final Lazy f16714g = LazyKt.b(new Function0() { // from class: bn.c
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            aq.c B;
            B = d.B(d.this);
            return B;
        }
    });

    public d(String str, String str2) {
        this.f16712e = str;
        this.f16713f = str2;
    }

    private final aq.c A() {
        return (aq.c) this.f16714g.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final aq.c B(d dVar) {
        IRoomApi iRoomApi = (IRoomApi) TheRouter.d(IRoomApi.class, new Object[0]);
        if (iRoomApi != null) {
            return iRoomApi.c(dVar.k(), RoomsViewType.TYPE_SUBJECT_DETAIL);
        }
        return null;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int l() {
        return MediaType.ROOM_LIST.ordinal();
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int m() {
        return R$layout.movie_detail_item_rooms;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder helper, PostSubjectItem item) {
        View view;
        aq.c A;
        Intrinsics.h(helper, "helper");
        Intrinsics.h(item, "item");
        FrameLayout frameLayout = (FrameLayout) helper.getView(R$id.fl_root);
        String str = this.f16712e;
        if (str != null) {
            String str2 = this.f16713f;
            if (str2 == null) {
                str2 = ProfileSubSource.COMMENTS.getValue();
            }
            aq.c A2 = A();
            if (A2 != null) {
                A2.setReportName(str, str2);
            }
        }
        List<RoomItem> roomList = item.getRoomList();
        if (roomList != null && (A = A()) != null) {
            A.setList(roomList);
        }
        aq.c A3 = A();
        if (A3 == null || (view = A3.getView()) == null || frameLayout.indexOfChild(view) != -1) {
            return;
        }
        frameLayout.removeAllViews();
        frameLayout.addView(view);
    }
}
