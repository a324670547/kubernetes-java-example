package club.mydlq.kubernetes.example.get;

import io.kubernetes.client.ApiException;
import io.kubernetes.client.apis.ExtensionsV1beta1Api;
import io.kubernetes.client.models.V1beta1Ingress;
import io.kubernetes.client.models.V1beta1IngressList;

/**
 * - 描述：获取 Ingress
 * - API版本： extensions/v1
 */
public class GetIngress {

    /**
     * 获取全部 Namespace 的 Ingess 列表
     */
    public static void getAllIngress() throws ApiException {
        // 设置 Api 客户端
        ExtensionsV1beta1Api extensionsApi = new ExtensionsV1beta1Api();
        // 获取全部 Namespace 的 Ingess 列表
        V1beta1IngressList ingressList = extensionsApi.listIngressForAllNamespaces(null, null, null, null, null, null, null, null, null);
        for (V1beta1Ingress item : ingressList.getItems()) {
            System.out.println(item.getMetadata().getName());
        }
    }

    /**
     * 获取某个 Namespace 的 Ingress 列表
     */
    public static void getNamespaceIngressList(String namespace) throws ApiException {
        // 设置 Api 客户端
        ExtensionsV1beta1Api extensionsApi = new ExtensionsV1beta1Api();
        // 获取某个 Namespace 下的 Ingress 列表
        V1beta1IngressList ingressList = extensionsApi.listNamespacedIngress(namespace, null, null, null,null,null,null,null,null,null);
        for (V1beta1Ingress item : ingressList.getItems()) {
            System.out.println(item.getMetadata().getName());
        }
    }

    /**
     * 获取某个 Namespace 的某个 Ingress
     */
    public static void getNamespaceIngress(String namespace,String ingressName) throws ApiException {
        // 设置 Api 客户端
        ExtensionsV1beta1Api extensionsApi = new ExtensionsV1beta1Api();
        // 获取某个 Namespace 下的 Ingress
        V1beta1Ingress ingress = extensionsApi.readNamespacedIngress(ingressName , namespace, null, null, null);
        System.out.println(ingress);
    }

    /**
     * 获取 Ingress
     */
    public static void main(String[] args) throws Exception {
        // 连接 Kubernetes 集群
        ConnectKubernetes.connectFromTokenByFile();
        // 获取全部 Namespace 的 Ingess 列表
        getAllIngress();
        // 获取某个 Namespace 的 Ingress 列表
        getNamespaceIngressList("namespace");
        // 获取某个 Namespace 的某个 Ingress
        getNamespaceIngress("namespace","ingressName");
    }

}
