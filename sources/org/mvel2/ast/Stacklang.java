package org.mvel2.ast;

import com.cloud.tmc.integration.params.TmcStartParams;
import com.cloud.tmc.integration.ui.p001native.NativeImgComponent;
import com.cloud.tmc.offline.download.model.TaskResultKt;
import com.google.android.libraries.places.api.model.PlaceTypes;
import com.transsion.mpush.core.config.PushMsgSource;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.mvel2.CompileException;
import org.mvel2.ParserContext;
import org.mvel2.integration.VariableResolver;
import org.mvel2.integration.VariableResolverFactory;
import org.mvel2.util.g;
import org.mvel2.util.m;

/* loaded from: classes7.dex */
public class Stacklang extends BlockNode {
    static final Map<String, Integer> opcodes;
    List<b> instructionList;
    ParserContext pCtx;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        int f72071a;

        /* renamed from: b, reason: collision with root package name */
        String f72072b;

        /* renamed from: c, reason: collision with root package name */
        Object f72073c;

        private b() {
        }
    }

    static {
        HashMap hashMap = new HashMap();
        opcodes = hashMap;
        hashMap.put(PushMsgSource.SOURCE_PUSH, 102);
        hashMap.put(TmcStartParams.BACK_BEHAVIOR_POP, 103);
        hashMap.put(NativeImgComponent.EVENT_LOAD, 104);
        hashMap.put("ldtype", 105);
        hashMap.put("invoke", 106);
        hashMap.put(PlaceTypes.STORE, 109);
        hashMap.put("getfield", 107);
        hashMap.put("storefield", Integer.valueOf(TaskResultKt.ERROR_LOAD_RESPONSE_STR_EMPTY));
        hashMap.put("dup", 110);
        hashMap.put("jump", 112);
        hashMap.put("jumpif", 113);
        hashMap.put("label", 111);
        hashMap.put("eq", 18);
        hashMap.put("ne", 19);
        hashMap.put("reduce", Integer.valueOf(Sdk$SDKError.Reason.ASSET_WRITE_ERROR_VALUE));
        hashMap.put("xswap", Integer.valueOf(Sdk$SDKError.Reason.GZIP_ENCODE_ERROR_VALUE));
        hashMap.put("swap", Integer.valueOf(Sdk$SDKError.Reason.INVALID_INDEX_URL_VALUE));
    }

    public Stacklang(char[] cArr, int i11, int i12, int i13, ParserContext parserContext) {
        super(parserContext);
        this.expr = cArr;
        this.blockStart = i11;
        this.blockOffset = i12;
        this.fields = i13 | 4194304;
        String[] split = new String(cArr, i11, i12).split(";");
        this.instructionList = new ArrayList(split.length);
        for (String str : split) {
            this.instructionList.add(parseInstruction(str.trim()));
        }
        this.pCtx = parserContext;
    }

    private static b parseInstruction(String str) {
        int indexOf = str.indexOf(32);
        b bVar = new b();
        String substring = indexOf == -1 ? str : str.substring(0, indexOf);
        Map<String, Integer> map = opcodes;
        if (map.containsKey(substring)) {
            bVar.f72071a = map.get(substring).intValue();
        }
        if (substring != str) {
            bVar.f72072b = str.substring(indexOf + 1);
        }
        return bVar;
    }

    @Override // org.mvel2.ast.ASTNode
    public Object getReducedValue(Object obj, Object obj2, VariableResolverFactory variableResolverFactory) {
        Field field;
        Method method;
        Constructor constructor;
        g gVar = (g) obj;
        int size = this.instructionList.size();
        int i11 = 0;
        while (i11 < size) {
            b bVar = this.instructionList.get(i11);
            System.out.println(gVar.toString() + " >> " + bVar.f72071a + ":" + bVar.f72072b);
            int i12 = bVar.f72071a;
            if (i12 == 18) {
                gVar.q(Boolean.valueOf(gVar.n().equals(gVar.n())));
            } else if (i12 != 19) {
                switch (i12) {
                    case 102:
                        if (bVar.f72073c == null) {
                            bVar.f72073c = org.mvel2.d.n(bVar.f72072b, obj, variableResolverFactory);
                        }
                        gVar.q(bVar.f72073c);
                        break;
                    case 103:
                        gVar.n();
                        break;
                    case 104:
                        if (bVar.f72073c == null) {
                            bVar.f72073c = variableResolverFactory.getVariableResolver(bVar.f72072b);
                        }
                        gVar.q(((VariableResolver) bVar.f72073c).getValue());
                        break;
                    case 105:
                        try {
                            if (bVar.f72073c == null) {
                                bVar.f72073c = m.v(bVar.f72072b, this.pCtx);
                            }
                            gVar.q(bVar.f72073c);
                            break;
                        } catch (ClassNotFoundException e11) {
                            throw new CompileException("error", this.expr, this.blockStart, e11);
                        }
                    case 106:
                        g gVar2 = new g();
                        while (!gVar.g() && !(gVar.k() instanceof Class)) {
                            gVar2.q(gVar.n());
                        }
                        if (gVar.g()) {
                            throw new CompileException("invoke without class", this.expr, this.blockStart);
                        }
                        Object[] objArr = new Object[gVar2.t()];
                        int i13 = 0;
                        while (!gVar2.g()) {
                            objArr[i13] = gVar2.n();
                            i13++;
                        }
                        if ("<init>".equals(bVar.f72072b)) {
                            Object obj3 = bVar.f72073c;
                            if (obj3 == null) {
                                constructor = m.N(objArr, (Class) gVar.n(), false);
                                bVar.f72073c = constructor;
                            } else {
                                constructor = (Constructor) obj3;
                            }
                            try {
                                gVar.q(constructor.newInstance(objArr));
                                break;
                            } catch (Exception e12) {
                                throw new CompileException("instantiation error", this.expr, this.blockStart, e12);
                            }
                        } else {
                            if (bVar.f72073c == null) {
                                Class cls = (Class) gVar.n();
                                method = m.L(objArr, bVar.f72072b, cls, cls.getDeclaredMethods(), false);
                                bVar.f72073c = method;
                            } else {
                                gVar.e();
                                method = (Method) bVar.f72073c;
                            }
                            try {
                                gVar.q(method.invoke(gVar.g() ? null : gVar.n(), objArr));
                                break;
                            } catch (Exception e13) {
                                throw new CompileException("invokation error", this.expr, this.blockStart, e13);
                            }
                        }
                    case 107:
                        try {
                            if (!gVar.g() && (gVar.k() instanceof Class)) {
                                if (bVar.f72073c == null) {
                                    field = ((Class) gVar.n()).getField(bVar.f72072b);
                                    bVar.f72073c = field;
                                } else {
                                    gVar.e();
                                    field = (Field) bVar.f72073c;
                                }
                                gVar.q(field.get(gVar.n()));
                                break;
                            } else {
                                throw new CompileException("getfield without class", this.expr, this.blockStart);
                            }
                        } catch (Exception e14) {
                            throw new CompileException("field access error", this.expr, this.blockStart, e14);
                        }
                    case TaskResultKt.ERROR_LOAD_RESPONSE_STR_EMPTY /* 108 */:
                        try {
                            if (!gVar.g() && (gVar.k() instanceof Class)) {
                                Class cls2 = (Class) gVar.n();
                                Object n11 = gVar.n();
                                cls2.getField(bVar.f72072b).set(gVar.n(), n11);
                                gVar.q(n11);
                                break;
                            } else {
                                throw new CompileException("storefield without class", this.expr, this.blockStart);
                            }
                        } catch (Exception e15) {
                            throw new CompileException("field access error", this.expr, this.blockStart, e15);
                        }
                    case 109:
                        Object obj4 = bVar.f72073c;
                        if (obj4 != null) {
                            ((VariableResolver) obj4).setValue(gVar.k());
                            break;
                        } else {
                            bVar.f72073c = variableResolverFactory.createVariable(bVar.f72072b, gVar.k());
                            break;
                        }
                    case 110:
                        gVar.f();
                        break;
                    default:
                        switch (i12) {
                            case 113:
                                if (!gVar.p().booleanValue()) {
                                    break;
                                }
                                break;
                            case ASSET_WRITE_ERROR_VALUE:
                                gVar.i();
                                continue;
                            case INVALID_INDEX_URL_VALUE:
                                Object n12 = gVar.n();
                                Object n13 = gVar.n();
                                gVar.q(n12);
                                gVar.q(n13);
                                continue;
                            case GZIP_ENCODE_ERROR_VALUE:
                                gVar.v();
                                continue;
                        }
                        Object obj5 = bVar.f72073c;
                        if (obj5 == null) {
                            int i14 = 0;
                            while (true) {
                                if (i14 < this.instructionList.size()) {
                                    b bVar2 = this.instructionList.get(i14);
                                    if (bVar2.f72071a == 111 && bVar.f72072b.equals(bVar2.f72072b)) {
                                        bVar.f72073c = Integer.valueOf(i14);
                                        i11 = i14;
                                        break;
                                    } else {
                                        i14++;
                                    }
                                }
                            }
                        } else {
                            i11 = ((Integer) obj5).intValue();
                            break;
                        }
                        break;
                }
            } else {
                gVar.q(Boolean.valueOf(!gVar.n().equals(gVar.n())));
            }
            i11++;
        }
        return gVar.n();
    }

    @Override // org.mvel2.ast.ASTNode
    public Object getReducedValueAccelerated(Object obj, Object obj2, VariableResolverFactory variableResolverFactory) {
        g gVar = new g();
        gVar.q(getReducedValue(gVar, obj2, variableResolverFactory));
        if (gVar.h()) {
            while (true) {
                gVar.i();
                if (!gVar.h()) {
                    break;
                }
                gVar.u();
            }
        }
        return gVar.k();
    }
}
