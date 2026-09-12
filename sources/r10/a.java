package r10;

import java.util.HashMap;
import java.util.Map;
import org.mvel2.templates.CompiledTemplate;
import org.mvel2.templates.TemplateError;

/* loaded from: classes7.dex */
public class a implements c {

    /* renamed from: a, reason: collision with root package name */
    private Map f74141a = new HashMap();

    @Override // r10.c
    public CompiledTemplate a(String str) {
        CompiledTemplate compiledTemplate = (CompiledTemplate) this.f74141a.get(str);
        if (compiledTemplate != null) {
            return compiledTemplate;
        }
        throw new TemplateError("no named template exists '" + str + "'");
    }

    @Override // r10.c
    public void b(String str, CompiledTemplate compiledTemplate) {
        this.f74141a.put(str, compiledTemplate);
    }
}
