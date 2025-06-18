package SolidPrinciples.P4_InterfaceSegregationPrincipal.ProblematicCode;


/**
 * this  code is problematic because
 * admin -can do all thing
 * buyer - can only buy
 * seller - modify products , add , buy
 *
 * but its not following lsp and isp
 *
 * we can divide it into iInteface and implement all the funciton independetly
 */

public interface User {

    boolean canBuyProducts();

    boolean canModifyProducts();

    boolean canAddProducts();

    boolean canApproveProducts();

    void approveProduct();
}