package club.mydlq.kubernetes.example.get;

import io.kubernetes.client.ApiException;
import io.kubernetes.client.apis.CoreV1Api;
import io.kubernetes.client.models.V1Secret;
import io.kubernetes.client.models.V1SecretList;

/**
 * - 描述：获取 Secret
 * - API版本： v1
 */
public class GetSecret {

    /**
     * 获取全部 Namespace 的 Secret 列表
     */
    public static void getAllSecret() throws ApiException {
        // Api对象
        CoreV1Api api = new CoreV1Api();
        // 获取全部 Namespace 的 Secret 列表
        V1SecretList SecretList = api.listSecretForAllNamespaces(null, null, null, null, null, null, null, null, null);
        for (V1Secret item : SecretList.getItems()) {
            System.out.println(item.getMetadata().getName());
        }
    }

    /**
     * 获取某个 Namespace 的 Secret 列表
     */
    public static void getNamespaceSecretList(String namespace) throws ApiException {
        // Api对象
        CoreV1Api api = new CoreV1Api();
        // 获取某个 Namespace 下的 Secret 列表
        V1SecretList SecretList = api.listNamespacedSecret(namespace, null, null,null, null, null, null, null, null, null);
        for (V1Secret item : SecretList.getItems()) {
            System.out.println(item.getMetadata().getName());
        }
    }

    /**
     * 获取某个 Namespace 的某个 Secret
     */
    public static void getNamespaceSecret(String namespace, String SecretName) throws ApiException {
        // Api对象
        CoreV1Api api = new CoreV1Api();
        // 获取某个 Namespace 下的 Secret
        V1Secret Secret = api.readNamespacedSecret(SecretName, namespace, null, null, null);
        System.out.println(Secret);
    }

    /**
     * 获取 Secret
     */
    public static void main(String[] args) throws Exception {
        // 连接 Kubernetes 集群
        ConnectKubernetes.connectFromTokenByFile();
        // 获取全部 Namespace 的 Secret 列表
        getAllSecret();
        // 获取某个 Namespace 的 Secret 列表
        getNamespaceSecretList("kube-system");
        // 获取某个 Namespace 的某个 Secret
        getNamespaceSecret("kube-system", "replication-controller-token-x9gx9");
    }

}
