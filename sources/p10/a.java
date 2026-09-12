package p10;

import com.transsion.mpush.core.config.PushMsgSource;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes7.dex */
public class a {
    public Map a() {
        HashMap hashMap = new HashMap();
        hashMap.put("set", new f());
        hashMap.put(PushMsgSource.SOURCE_PUSH, new e());
        hashMap.put("help", new c());
        hashMap.put("showvars", new g());
        hashMap.put("inspect", new d());
        hashMap.put("exit", new b());
        return hashMap;
    }
}
