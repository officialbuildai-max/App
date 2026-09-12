package mn;

import androidx.room.RoomDatabase;
import com.cloud.tmc.integration.event.EventConstants;
import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import com.hisavana.common.tracking.TrackingKey;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.transsion.mpush.api.LocalPushMessage;
import com.transsion.ninegridview.preview.GifImagePreviewActivity;
import com.transsion.push.PushConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;

/* loaded from: classes6.dex */
public final class i implements mn.a {

    /* renamed from: a, reason: collision with root package name */
    private final RoomDatabase f69764a;

    /* renamed from: b, reason: collision with root package name */
    private final androidx.room.g f69765b = new a();

    /* renamed from: c, reason: collision with root package name */
    private final androidx.room.e f69766c = new b();

    /* loaded from: classes6.dex */
    class a extends androidx.room.g {
        a() {
        }

        @Override // androidx.room.g
        protected String b() {
            return "INSERT OR REPLACE INTO `msg_standard` (`id`,`message_id`,`title`,`desc`,`deep_link`,`image_list`,`push_time`,`source`,`style`,`type`,`receive_time`,`msg_status`,`show_time`,`force_show`,`has_screen_on`,`extra_map`,`built_in`,`permanent_msg_status`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.room.g
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void a(z3.e eVar, LocalPushMessage localPushMessage) {
            eVar.c(1, localPushMessage.getId());
            if (localPushMessage.getMessageId() == null) {
                eVar.g(2);
            } else {
                eVar.j(2, localPushMessage.getMessageId());
            }
            if (localPushMessage.getTitle() == null) {
                eVar.g(3);
            } else {
                eVar.j(3, localPushMessage.getTitle());
            }
            if (localPushMessage.getDesc() == null) {
                eVar.g(4);
            } else {
                eVar.j(4, localPushMessage.getDesc());
            }
            if (localPushMessage.getDeeplink() == null) {
                eVar.g(5);
            } else {
                eVar.j(5, localPushMessage.getDeeplink());
            }
            if (localPushMessage.getImageList() == null) {
                eVar.g(6);
            } else {
                eVar.j(6, localPushMessage.getImageList());
            }
            if (localPushMessage.getPushTime() == null) {
                eVar.g(7);
            } else {
                eVar.j(7, localPushMessage.getPushTime());
            }
            if (localPushMessage.getSource() == null) {
                eVar.g(8);
            } else {
                eVar.j(8, localPushMessage.getSource());
            }
            if (localPushMessage.getStyle() == null) {
                eVar.g(9);
            } else {
                eVar.j(9, localPushMessage.getStyle());
            }
            if (localPushMessage.getType() == null) {
                eVar.g(10);
            } else {
                eVar.j(10, localPushMessage.getType());
            }
            eVar.c(11, localPushMessage.getReceiveTime());
            eVar.c(12, localPushMessage.getMsgStatus());
            eVar.c(13, localPushMessage.getShowTime());
            eVar.c(14, localPushMessage.getForceShow() ? 1L : 0L);
            eVar.c(15, localPushMessage.getHasScreenOn() ? 1L : 0L);
            if (localPushMessage.getExtraMap() == null) {
                eVar.g(16);
            } else {
                eVar.j(16, localPushMessage.getExtraMap());
            }
            eVar.c(17, localPushMessage.getBuiltIn() ? 1L : 0L);
            eVar.c(18, localPushMessage.getPermanentMsgStatus());
        }
    }

    /* loaded from: classes6.dex */
    class b extends androidx.room.e {
        b() {
        }

        @Override // androidx.room.e
        protected String b() {
            return "UPDATE OR ABORT `msg_standard` SET `id` = ?,`message_id` = ?,`title` = ?,`desc` = ?,`deep_link` = ?,`image_list` = ?,`push_time` = ?,`source` = ?,`style` = ?,`type` = ?,`receive_time` = ?,`msg_status` = ?,`show_time` = ?,`force_show` = ?,`has_screen_on` = ?,`extra_map` = ?,`built_in` = ?,`permanent_msg_status` = ? WHERE `id` = ?";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.room.e
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(z3.e eVar, LocalPushMessage localPushMessage) {
            eVar.c(1, localPushMessage.getId());
            if (localPushMessage.getMessageId() == null) {
                eVar.g(2);
            } else {
                eVar.j(2, localPushMessage.getMessageId());
            }
            if (localPushMessage.getTitle() == null) {
                eVar.g(3);
            } else {
                eVar.j(3, localPushMessage.getTitle());
            }
            if (localPushMessage.getDesc() == null) {
                eVar.g(4);
            } else {
                eVar.j(4, localPushMessage.getDesc());
            }
            if (localPushMessage.getDeeplink() == null) {
                eVar.g(5);
            } else {
                eVar.j(5, localPushMessage.getDeeplink());
            }
            if (localPushMessage.getImageList() == null) {
                eVar.g(6);
            } else {
                eVar.j(6, localPushMessage.getImageList());
            }
            if (localPushMessage.getPushTime() == null) {
                eVar.g(7);
            } else {
                eVar.j(7, localPushMessage.getPushTime());
            }
            if (localPushMessage.getSource() == null) {
                eVar.g(8);
            } else {
                eVar.j(8, localPushMessage.getSource());
            }
            if (localPushMessage.getStyle() == null) {
                eVar.g(9);
            } else {
                eVar.j(9, localPushMessage.getStyle());
            }
            if (localPushMessage.getType() == null) {
                eVar.g(10);
            } else {
                eVar.j(10, localPushMessage.getType());
            }
            eVar.c(11, localPushMessage.getReceiveTime());
            eVar.c(12, localPushMessage.getMsgStatus());
            eVar.c(13, localPushMessage.getShowTime());
            eVar.c(14, localPushMessage.getForceShow() ? 1L : 0L);
            eVar.c(15, localPushMessage.getHasScreenOn() ? 1L : 0L);
            if (localPushMessage.getExtraMap() == null) {
                eVar.g(16);
            } else {
                eVar.j(16, localPushMessage.getExtraMap());
            }
            eVar.c(17, localPushMessage.getBuiltIn() ? 1L : 0L);
            eVar.c(18, localPushMessage.getPermanentMsgStatus());
            eVar.c(19, localPushMessage.getId());
        }
    }

    public i(RoomDatabase roomDatabase) {
        this.f69764a = roomDatabase;
    }

    public static List o() {
        return Collections.emptyList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit p(z3.b bVar) {
        z3.e D0 = bVar.D0("DELETE FROM msg_standard");
        try {
            D0.A0();
            return Unit.f67184a;
        } finally {
            D0.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List q(z3.b bVar) {
        boolean z10;
        int i11;
        int i12;
        int i13;
        boolean z11;
        int i14;
        String n02;
        int i15;
        int i16;
        boolean z12;
        z3.e D0 = bVar.D0("SELECT * FROM msg_standard ORDER BY receive_time DESC");
        try {
            int d11 = androidx.room.util.k.d(D0, "id");
            int d12 = androidx.room.util.k.d(D0, PushConstants.EXTRA_PUSH_MESSAGE_ID);
            int d13 = androidx.room.util.k.d(D0, CampaignEx.JSON_KEY_TITLE);
            int d14 = androidx.room.util.k.d(D0, CampaignEx.JSON_KEY_DESC);
            int d15 = androidx.room.util.k.d(D0, CampaignEx.JSON_KEY_DEEP_LINK_URL);
            int d16 = androidx.room.util.k.d(D0, GifImagePreviewActivity.IMAGE_LIST);
            int d17 = androidx.room.util.k.d(D0, "push_time");
            int d18 = androidx.room.util.k.d(D0, EventConstants.KEY_SOURCE);
            int d19 = androidx.room.util.k.d(D0, TtmlNode.TAG_STYLE);
            int d20 = androidx.room.util.k.d(D0, NativeComponentConstants.KEY_COMPONENT_TYPE);
            int d21 = androidx.room.util.k.d(D0, "receive_time");
            int d22 = androidx.room.util.k.d(D0, "msg_status");
            int d23 = androidx.room.util.k.d(D0, TrackingKey.SHOW_TIME);
            int d24 = androidx.room.util.k.d(D0, "force_show");
            int d25 = androidx.room.util.k.d(D0, "has_screen_on");
            int d26 = androidx.room.util.k.d(D0, "extra_map");
            int d27 = androidx.room.util.k.d(D0, "built_in");
            int d28 = androidx.room.util.k.d(D0, "permanent_msg_status");
            ArrayList arrayList = new ArrayList();
            while (D0.A0()) {
                int i17 = d24;
                ArrayList arrayList2 = arrayList;
                int i18 = (int) D0.getLong(d11);
                String n03 = D0.isNull(d12) ? null : D0.n0(d12);
                String n04 = D0.isNull(d13) ? null : D0.n0(d13);
                String n05 = D0.isNull(d14) ? null : D0.n0(d14);
                String n06 = D0.isNull(d15) ? null : D0.n0(d15);
                String n07 = D0.isNull(d16) ? null : D0.n0(d16);
                String n08 = D0.isNull(d17) ? null : D0.n0(d17);
                String n09 = D0.isNull(d18) ? null : D0.n0(d18);
                String n010 = D0.isNull(d19) ? null : D0.n0(d19);
                String n011 = D0.isNull(d20) ? null : D0.n0(d20);
                long j11 = D0.getLong(d21);
                int i19 = d12;
                int i20 = d13;
                int i21 = (int) D0.getLong(d22);
                long j12 = D0.getLong(d23);
                int i22 = d15;
                int i23 = d14;
                if (((int) D0.getLong(i17)) != 0) {
                    i11 = d25;
                    i12 = d16;
                    z10 = true;
                } else {
                    z10 = false;
                    i11 = d25;
                    i12 = d16;
                }
                if (((int) D0.getLong(i11)) != 0) {
                    i13 = d26;
                    z11 = true;
                } else {
                    i13 = d26;
                    z11 = false;
                }
                if (D0.isNull(i13)) {
                    i14 = i17;
                    i15 = d27;
                    n02 = null;
                } else {
                    i14 = i17;
                    n02 = D0.n0(i13);
                    i15 = d27;
                }
                int i24 = i11;
                if (((int) D0.getLong(i15)) != 0) {
                    i16 = d28;
                    z12 = true;
                } else {
                    i16 = d28;
                    z12 = false;
                }
                int i25 = i13;
                arrayList2.add(new LocalPushMessage(i18, n03, n04, n05, n06, n07, n08, n09, n010, n011, j11, i21, j12, z10, z11, n02, z12, (int) D0.getLong(i16)));
                d24 = i14;
                d26 = i25;
                d14 = i23;
                d15 = i22;
                d28 = i16;
                d13 = i20;
                int i26 = i15;
                d16 = i12;
                d25 = i24;
                d27 = i26;
                arrayList = arrayList2;
                d12 = i19;
            }
            return arrayList;
        } finally {
            D0.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ LocalPushMessage r(String str, z3.b bVar) {
        int i11;
        boolean z10;
        boolean z11;
        int i12;
        z3.e D0 = bVar.D0("SELECT * FROM msg_standard WHERE message_id = ? LIMIT 1");
        try {
            if (str == null) {
                D0.g(1);
            } else {
                D0.j(1, str);
            }
            int d11 = androidx.room.util.k.d(D0, "id");
            int d12 = androidx.room.util.k.d(D0, PushConstants.EXTRA_PUSH_MESSAGE_ID);
            int d13 = androidx.room.util.k.d(D0, CampaignEx.JSON_KEY_TITLE);
            int d14 = androidx.room.util.k.d(D0, CampaignEx.JSON_KEY_DESC);
            int d15 = androidx.room.util.k.d(D0, CampaignEx.JSON_KEY_DEEP_LINK_URL);
            int d16 = androidx.room.util.k.d(D0, GifImagePreviewActivity.IMAGE_LIST);
            int d17 = androidx.room.util.k.d(D0, "push_time");
            int d18 = androidx.room.util.k.d(D0, EventConstants.KEY_SOURCE);
            int d19 = androidx.room.util.k.d(D0, TtmlNode.TAG_STYLE);
            int d20 = androidx.room.util.k.d(D0, NativeComponentConstants.KEY_COMPONENT_TYPE);
            int d21 = androidx.room.util.k.d(D0, "receive_time");
            int d22 = androidx.room.util.k.d(D0, "msg_status");
            int d23 = androidx.room.util.k.d(D0, TrackingKey.SHOW_TIME);
            int d24 = androidx.room.util.k.d(D0, "force_show");
            int d25 = androidx.room.util.k.d(D0, "has_screen_on");
            int d26 = androidx.room.util.k.d(D0, "extra_map");
            int d27 = androidx.room.util.k.d(D0, "built_in");
            int d28 = androidx.room.util.k.d(D0, "permanent_msg_status");
            LocalPushMessage localPushMessage = null;
            if (D0.A0()) {
                int i13 = (int) D0.getLong(d11);
                String n02 = D0.isNull(d12) ? null : D0.n0(d12);
                String n03 = D0.isNull(d13) ? null : D0.n0(d13);
                String n04 = D0.isNull(d14) ? null : D0.n0(d14);
                String n05 = D0.isNull(d15) ? null : D0.n0(d15);
                String n06 = D0.isNull(d16) ? null : D0.n0(d16);
                String n07 = D0.isNull(d17) ? null : D0.n0(d17);
                String n08 = D0.isNull(d18) ? null : D0.n0(d18);
                String n09 = D0.isNull(d19) ? null : D0.n0(d19);
                String n010 = D0.isNull(d20) ? null : D0.n0(d20);
                long j11 = D0.getLong(d21);
                int i14 = (int) D0.getLong(d22);
                long j12 = D0.getLong(d23);
                if (((int) D0.getLong(d24)) != 0) {
                    z10 = true;
                    i11 = d25;
                } else {
                    i11 = d25;
                    z10 = false;
                }
                if (((int) D0.getLong(i11)) != 0) {
                    i12 = d26;
                    z11 = true;
                } else {
                    z11 = false;
                    i12 = d26;
                }
                localPushMessage = new LocalPushMessage(i13, n02, n03, n04, n05, n06, n07, n08, n09, n010, j11, i14, j12, z10, z11, D0.isNull(i12) ? null : D0.n0(i12), ((int) D0.getLong(d27)) != 0, (int) D0.getLong(d28));
            }
            D0.close();
            return localPushMessage;
        } catch (Throwable th2) {
            D0.close();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List s(z3.b bVar) {
        boolean z10;
        int i11;
        int i12;
        int i13;
        boolean z11;
        int i14;
        String n02;
        int i15;
        int i16;
        boolean z12;
        z3.e D0 = bVar.D0("SELECT * FROM msg_standard WHERE msg_status = 0 ORDER BY receive_time DESC");
        try {
            int d11 = androidx.room.util.k.d(D0, "id");
            int d12 = androidx.room.util.k.d(D0, PushConstants.EXTRA_PUSH_MESSAGE_ID);
            int d13 = androidx.room.util.k.d(D0, CampaignEx.JSON_KEY_TITLE);
            int d14 = androidx.room.util.k.d(D0, CampaignEx.JSON_KEY_DESC);
            int d15 = androidx.room.util.k.d(D0, CampaignEx.JSON_KEY_DEEP_LINK_URL);
            int d16 = androidx.room.util.k.d(D0, GifImagePreviewActivity.IMAGE_LIST);
            int d17 = androidx.room.util.k.d(D0, "push_time");
            int d18 = androidx.room.util.k.d(D0, EventConstants.KEY_SOURCE);
            int d19 = androidx.room.util.k.d(D0, TtmlNode.TAG_STYLE);
            int d20 = androidx.room.util.k.d(D0, NativeComponentConstants.KEY_COMPONENT_TYPE);
            int d21 = androidx.room.util.k.d(D0, "receive_time");
            int d22 = androidx.room.util.k.d(D0, "msg_status");
            int d23 = androidx.room.util.k.d(D0, TrackingKey.SHOW_TIME);
            int d24 = androidx.room.util.k.d(D0, "force_show");
            int d25 = androidx.room.util.k.d(D0, "has_screen_on");
            int d26 = androidx.room.util.k.d(D0, "extra_map");
            int d27 = androidx.room.util.k.d(D0, "built_in");
            int d28 = androidx.room.util.k.d(D0, "permanent_msg_status");
            ArrayList arrayList = new ArrayList();
            while (D0.A0()) {
                int i17 = d24;
                ArrayList arrayList2 = arrayList;
                int i18 = (int) D0.getLong(d11);
                String n03 = D0.isNull(d12) ? null : D0.n0(d12);
                String n04 = D0.isNull(d13) ? null : D0.n0(d13);
                String n05 = D0.isNull(d14) ? null : D0.n0(d14);
                String n06 = D0.isNull(d15) ? null : D0.n0(d15);
                String n07 = D0.isNull(d16) ? null : D0.n0(d16);
                String n08 = D0.isNull(d17) ? null : D0.n0(d17);
                String n09 = D0.isNull(d18) ? null : D0.n0(d18);
                String n010 = D0.isNull(d19) ? null : D0.n0(d19);
                String n011 = D0.isNull(d20) ? null : D0.n0(d20);
                long j11 = D0.getLong(d21);
                int i19 = d12;
                int i20 = d13;
                int i21 = (int) D0.getLong(d22);
                long j12 = D0.getLong(d23);
                int i22 = d15;
                int i23 = d14;
                if (((int) D0.getLong(i17)) != 0) {
                    i11 = d25;
                    i12 = d16;
                    z10 = true;
                } else {
                    z10 = false;
                    i11 = d25;
                    i12 = d16;
                }
                if (((int) D0.getLong(i11)) != 0) {
                    i13 = d26;
                    z11 = true;
                } else {
                    i13 = d26;
                    z11 = false;
                }
                if (D0.isNull(i13)) {
                    i14 = i17;
                    i15 = d27;
                    n02 = null;
                } else {
                    i14 = i17;
                    n02 = D0.n0(i13);
                    i15 = d27;
                }
                int i24 = i11;
                if (((int) D0.getLong(i15)) != 0) {
                    i16 = d28;
                    z12 = true;
                } else {
                    i16 = d28;
                    z12 = false;
                }
                int i25 = i13;
                arrayList2.add(new LocalPushMessage(i18, n03, n04, n05, n06, n07, n08, n09, n010, n011, j11, i21, j12, z10, z11, n02, z12, (int) D0.getLong(i16)));
                d24 = i14;
                d26 = i25;
                d14 = i23;
                d15 = i22;
                d28 = i16;
                d13 = i20;
                int i26 = i15;
                d16 = i12;
                d25 = i24;
                d27 = i26;
                arrayList = arrayList2;
                d12 = i19;
            }
            return arrayList;
        } finally {
            D0.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit t(List list, z3.b bVar) {
        this.f69765b.c(bVar, list);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit u(LocalPushMessage localPushMessage, z3.b bVar) {
        this.f69766c.c(bVar, localPushMessage);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit v(int i11, String str, z3.b bVar) {
        z3.e D0 = bVar.D0("UPDATE msg_standard SET msg_status = ? WHERE message_id = ?");
        try {
            D0.c(1, i11);
            if (str == null) {
                D0.g(2);
            } else {
                D0.j(2, str);
            }
            D0.A0();
            Unit unit = Unit.f67184a;
            D0.close();
            return unit;
        } catch (Throwable th2) {
            D0.close();
            throw th2;
        }
    }

    @Override // mn.a
    public Object a(Continuation continuation) {
        return androidx.room.util.b.f(this.f69764a, false, true, new Function1() { // from class: mn.e
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit p11;
                p11 = i.p((z3.b) obj);
                return p11;
            }
        }, continuation);
    }

    @Override // mn.a
    public Object b(final List list, Continuation continuation) {
        list.getClass();
        return androidx.room.util.b.f(this.f69764a, false, true, new Function1() { // from class: mn.f
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit t11;
                t11 = i.this.t(list, (z3.b) obj);
                return t11;
            }
        }, continuation);
    }

    @Override // mn.a
    public Object c(final String str, final int i11, Continuation continuation) {
        return androidx.room.util.b.f(this.f69764a, false, true, new Function1() { // from class: mn.c
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit v11;
                v11 = i.v(i11, str, (z3.b) obj);
                return v11;
            }
        }, continuation);
    }

    @Override // mn.a
    public Object d(Continuation continuation) {
        return androidx.room.util.b.f(this.f69764a, true, false, new Function1() { // from class: mn.d
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                List q11;
                q11 = i.q((z3.b) obj);
                return q11;
            }
        }, continuation);
    }

    @Override // mn.a
    public Object e(Continuation continuation) {
        return androidx.room.util.b.f(this.f69764a, true, false, new Function1() { // from class: mn.b
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                List s11;
                s11 = i.s((z3.b) obj);
                return s11;
            }
        }, continuation);
    }

    @Override // mn.a
    public Object f(final LocalPushMessage localPushMessage, Continuation continuation) {
        localPushMessage.getClass();
        return androidx.room.util.b.f(this.f69764a, false, true, new Function1() { // from class: mn.g
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit u11;
                u11 = i.this.u(localPushMessage, (z3.b) obj);
                return u11;
            }
        }, continuation);
    }

    @Override // mn.a
    public Object g(final String str, Continuation continuation) {
        return androidx.room.util.b.f(this.f69764a, true, false, new Function1() { // from class: mn.h
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                LocalPushMessage r11;
                r11 = i.r(str, (z3.b) obj);
                return r11;
            }
        }, continuation);
    }
}
