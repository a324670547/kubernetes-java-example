package club.mydlq.kubernetes.example.get;

import io.kubernetes.client.ApiException;
import io.kubernetes.client.apis.CoreV1Api;
import io.kubernetes.client.models.V1Namespace;
import io.kubernetes.client.models.V1NamespaceList;

/**
 * - 描述：获取 Namespace
 * - API版本： v1
 */
public class GetNamespace {

    /**
     * 获取 Kubernetes 集群的全部 Namespace 列表
     */
    public static void getAllNamespace() throws ApiException {
        // 设置 Api 客户端
        CoreV1Api api = new CoreV1Api();
        // 获取全部 Namespace 列表
        V1NamespaceList namespaceList = api.listNamespace(null, null, null, null, null, null, null, null, null);
        for (V1Namespace item : namespaceList.getItems()) {
            System.out.println(item.getMetadata().getName());
        }
    }

    /**
     * 获取 Kubernetes 集群某个 Namespace 信息
     */
    public static void getNamespace(String namespaceName) throws ApiException {
        // 设置 Api 客户端
        CoreV1Api api = new CoreV1Api();
        // 获取某个 Namespace 信息
        V1Namespace namespace = api.readNamespace(namespaceName,null,null,null);
        System.out.println(namespace);
    }

    /**
     * 获取 Namespace
     */
    public static void main(String[] args) throws Exception {
        // 连接 Kubernetes 集群
        ConnectKubernetes.connectFromTokenByFile();
        // 获取 Kubernetes 集群的全部 Namespace 列表
        getAllNamespace();
        // 获取 Kubernetes 集群的某个 Namespace 信息
        getNamespace("kube-system");
    }

}
