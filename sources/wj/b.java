package wj;

import android.text.TextUtils;
import com.transsion.baselib.report.recent_event.ActionEvent;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final a f77816a = new a(null);

    /* renamed from: b, reason: collision with root package name */
    private static final wj.a f77817b = new wj.a(30);

    /* renamed from: c, reason: collision with root package name */
    private static final HashMap f77818c;

    /* renamed from: d, reason: collision with root package name */
    private static final HashMap f77819d;

    /* renamed from: e, reason: collision with root package name */
    private static final HashMap f77820e;

    /* loaded from: classes6.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final ActionEvent a(Map map, String str) {
            String str2 = (String) map.get("module_name");
            if (TextUtils.isEmpty(str2) || !b.f77818c.containsKey(str2)) {
                if (!TextUtils.equals(str, "Trending")) {
                    return null;
                }
                Integer num = (Integer) b.f77819d.get(str);
                return new ActionEvent(1, num != null ? num.intValue() : 0, f((String) map.get("post_id")), f((String) map.get("subject_id")), f((String) map.get("group_id")), 0, 0, 96, null);
            }
            Integer num2 = (Integer) b.f77819d.get(str);
            int intValue = num2 != null ? num2.intValue() : 0;
            String f11 = f((String) map.get("post_id"));
            String f12 = f((String) map.get("subject_id"));
            String f13 = f((String) map.get("group_id"));
            HashMap hashMap = b.f77818c;
            if (str2 == null) {
                str2 = "0";
            }
            return new ActionEvent(((Number) MapsKt.i(hashMap, str2)).intValue(), intValue, f11, f12, f13, 0, 0, 96, null);
        }

        private final ActionEvent b(Map map, String str) {
            if (TextUtils.equals(str, "postdetail")) {
                Integer num = (Integer) b.f77819d.get(str);
                return new ActionEvent(15, num != null ? num.intValue() : 0, f((String) map.get("post_id")), f((String) map.get("subject_id")), f((String) map.get("group_id")), 0, 0, 96, null);
            }
            if (!TextUtils.equals(str, "searchpage")) {
                return null;
            }
            Integer num2 = (Integer) b.f77819d.get(str);
            return new ActionEvent(19, num2 != null ? num2.intValue() : 0, "0", "0", "0", 0, 0, 96, null);
        }

        private final ActionEvent c(String str, Map map, String str2) {
            if (!b.f77819d.containsKey(str2)) {
                return null;
            }
            Integer num = (Integer) b.f77819d.get(str2);
            int intValue = num != null ? num.intValue() : 0;
            String f11 = f((String) map.get("post_id"));
            String f12 = f((String) map.get("subject_id"));
            String f13 = f((String) map.get("group_id"));
            String str3 = (String) map.get("play_duration");
            int parseInt = str3 != null ? Integer.parseInt(str3) : 0;
            String str4 = (String) map.get("completeCount");
            int parseInt2 = str4 != null ? Integer.parseInt(str4) : 0;
            Integer num2 = (Integer) b.f77820e.get(str);
            if (num2 != null) {
                return new ActionEvent(num2.intValue(), intValue, f11, f12, f13, parseInt, parseInt2);
            }
            return null;
        }

        private final String f(String str) {
            return (TextUtils.isEmpty(str) || str == null) ? "0" : str;
        }

        public final void d(String pageName, String event, Map map) {
            Intrinsics.h(pageName, "pageName");
            Intrinsics.h(event, "event");
            Intrinsics.h(map, "map");
            ActionEvent a11 = TextUtils.equals(event, "click") ? a(map, pageName) : TextUtils.equals(event, "pt") ? b(map, pageName) : (TextUtils.equals(event, "video_play") || TextUtils.equals(event, "audio_play")) ? c(event, map, pageName) : null;
            if (a11 != null) {
                b.f77817b.offer(a11);
            }
        }

        public final Queue e() {
            return b.f77817b;
        }
    }

    static {
        HashMap hashMap = new HashMap();
        f77818c = hashMap;
        HashMap hashMap2 = new HashMap();
        f77819d = hashMap2;
        HashMap hashMap3 = new HashMap();
        f77820e = hashMap3;
        hashMap.put("unknow", 0);
        hashMap.put("like", 3);
        hashMap.put("dislike", 4);
        hashMap.put("want_to_see", 5);
        hashMap.put("i_have_seen", 6);
        hashMap.put("create_review", 7);
        hashMap.put("copylink", 8);
        hashMap.put("whatsup", 8);
        hashMap.put("Telegram", 8);
        hashMap.put("create_post", 9);
        hashMap.put("checkin", 10);
        hashMap.put("checkout", 11);
        hashMap.put("download", 12);
        hashMap.put("comment", 13);
        hashMap.put("want_to_see_cancel", 17);
        hashMap.put("searchpage", 19);
        hashMap.put("search", 20);
        hashMap.put("download_subject", 21);
        hashMap2.put("default", 0);
        hashMap2.put("Trending", 1);
        hashMap2.put("roomdetail", 2);
        hashMap2.put("subjectdetail", 3);
        hashMap2.put("postdetail", 4);
        hashMap3.put("click", 1);
        hashMap3.put("audio_play", 2);
        hashMap3.put("video_play", 2);
        hashMap3.put("PT", 15);
    }
}
