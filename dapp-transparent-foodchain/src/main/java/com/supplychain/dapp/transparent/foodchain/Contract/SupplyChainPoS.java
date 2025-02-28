package com.supplychain.dapp.transparent.foodchain.Contract;

import io.reactivex.Flowable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.DynamicArray;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Bytes32;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.BaseEventResponse;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple10;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/hyperledger-web3j/web3j/tree/main/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 1.6.2.
 */
@SuppressWarnings("rawtypes")
public class SupplyChainPoS extends Contract {
    public static final String BINARY = "0x6080604052738a553b5a8ca7193820e99917569d3a6524b826d5600260006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550734839a2848f79b984e6c0cfc37bd45ffbcbc75d31600360006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055507329c32de5c3b1adfeee765dffb3ae6a238e9e6a1a600460006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555073d605bcede160eebf4e4c16de940f05411c063faf600560006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555034801561016457600080fd5b50611e3c806101746000396000f3fe608060405234801561001057600080fd5b50600436106100cf5760003560e01c80638ff371511161008c578063bfe1092811610066578063bfe109281461022f578063d811fcf01461024d578063eef7f8c31461026b578063f9cacefc14610287576100cf565b80638ff37151146101d95780639e98a8ef146101f7578063a066151314610213576100cf565b806316934fc4146100d4578063322f53d3146101045780634c1249fc1461013d5780635a74eb401461015b578063711b69051461018b5780637ec8c2eb146101bb575b600080fd5b6100ee60048036038101906100e99190611322565b6102c0565b6040516100fb9190611ba6565b60405180910390f35b61011e6004803603810190610119919061134b565b6102d8565b6040516101349a999897969594939291906119fc565b60405180910390f35b6101456104c3565b60405161015291906118ba565b60405180910390f35b61017560048036038101906101709190611404565b6104e9565b60405161018291906118f7565b60405180910390f35b6101a560048036038101906101a09190611458565b6108bd565b6040516101b291906118f7565b60405180910390f35b6101c36108e1565b6040516101d091906118ba565b60405180910390f35b6101e1610907565b6040516101ee91906118d5565b60405180910390f35b610211600480360381019061020c919061134b565b61095f565b005b61022d600480360381019061022891906113c8565b610abf565b005b610237610c8e565b60405161024491906118ba565b60405180910390f35b610255610cb4565b60405161026291906118ba565b60405180910390f35b61028560048036038101906102809190611374565b610cda565b005b6102a1600480360381019061029c919061134b565b610ec5565b6040516102b79a999897969594939291906119fc565b60405180910390f35b60016020528060005260406000206000915090505481565b60006020528060005260406000206000915090508060000180546102fb90611d16565b80601f016020809104026020016040519081016040528092919081815260200182805461032790611d16565b80156103745780601f1061034957610100808354040283529160200191610374565b820191906000526020600020905b81548152906001019060200180831161035757829003601f168201915b50505050509080600101549080600201805461038f90611d16565b80601f01602080910402602001604051908101604052809291908181526020018280546103bb90611d16565b80156104085780601f106103dd57610100808354040283529160200191610408565b820191906000526020600020905b8154815290600101906020018083116103eb57829003601f168201915b5050505050908060030154908060040160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff16908060050160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff16908060060160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff16908060060160149054906101000a900460ff16908060060160159054906101000a900460ff16908060060160169054906101000a900460ff1690508a565b600460009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b6000600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff161461057b576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040161057290611b06565b60405180910390fd5b600083834260405160200161059293929190611881565b60405160208183030381529060405280519060200120905060405180610140016040528085815260200184815260200160405180602001604052806000815250815260200160008152602001600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001600360009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001600460009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020016000151581526020016000151581526020016000151581525060008083815260200190815260200160002060008201518160000190805190602001906106df9291906111d8565b506020820151816001015560408201518160020190805190602001906107069291906111d8565b506060820151816003015560808201518160040160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555060a08201518160050160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555060c08201518160060160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555060e08201518160060160146101000a81548160ff0219169083151502179055506101008201518160060160156101000a81548160ff0219169083151502179055506101208201518160060160166101000a81548160ff02191690831515021790555090505060068190806001815401808255809150506001900390600052602060002001600090919091909150557f101fba3a271cf3dfe6af8237996b55248e088b018c1b77f630156a58d637d61f81338686426040516108ab959493929190611912565b60405180910390a18091505092915050565b600681815481106108cd57600080fd5b906000526020600020016000915090505481565b600560009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b6060600680548060200260200160405190810160405280929190818152602001828054801561095557602002820191906000526020600020905b815481526020019060010190808311610941575b5050505050905090565b600560009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16146109ef576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004016109e690611ae6565b60405180910390fd5b60008082815260200190815260200160002060060160169054906101000a900460ff1615610a52576040517f08c379a0000000000000000000000000000000000000000000000000000000008152600401610a4990611ac6565b60405180910390fd5b600160008083815260200190815260200160002060060160166101000a81548160ff0219169083151502179055507f71a21c76bdab1ccf99d5ab5967c17b03931b5b45c93ab38684f4d8b258d6b20981600142604051610ab49392919061196c565b60405180910390a150565b600460009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff1614610b4f576040517f08c379a0000000000000000000000000000000000000000000000000000000008152600401610b4690611b86565b60405180910390fd5b60008083815260200190815260200160002060060160149054906101000a900460ff16610bb1576040517f08c379a0000000000000000000000000000000000000000000000000000000008152600401610ba890611b66565b60405180910390fd5b60008060008481526020019081526020016000206003015414610c09576040517f08c379a0000000000000000000000000000000000000000000000000000000008152600401610c0090611b46565b60405180910390fd5b8060008084815260200190815260200160002060030181905550600160008084815260200190815260200160002060060160156101000a81548160ff0219169083151502179055507f63ebecafa6cd3a561f5ee003e50133568f9492544b2591d0aabe08c591f6ce5d8282604051610c829291906119d3565b60405180910390a15050565b600360009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b600360009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff1614610d6a576040517f08c379a0000000000000000000000000000000000000000000000000000000008152600401610d6190611aa6565b60405180910390fd5b60008060008481526020019081526020016000206002018054610d8c90611d16565b905014610dce576040517f08c379a0000000000000000000000000000000000000000000000000000000008152600401610dc590611b46565b60405180910390fd5b60008083815260200190815260200160002060060160169054906101000a900460ff16610e30576040517f08c379a0000000000000000000000000000000000000000000000000000000008152600401610e2790611b26565b60405180910390fd5b806000808481526020019081526020016000206002019080519060200190610e599291906111d8565b50600160008084815260200190815260200160002060060160146101000a81548160ff0219169083151502179055507f297c3157925a84c6ac54dbff2139db9266dded12b702ee17f3c32070eb5da4c38282604051610eb99291906119a3565b60405180910390a15050565b6060600060606000806000806000806000806000808d815260200190815260200160002060405180610140016040529081600082018054610f0590611d16565b80601f0160208091040260200160405190810160405280929190818152602001828054610f3190611d16565b8015610f7e5780601f10610f5357610100808354040283529160200191610f7e565b820191906000526020600020905b815481529060010190602001808311610f6157829003601f168201915b5050505050815260200160018201548152602001600282018054610fa190611d16565b80601f0160208091040260200160405190810160405280929190818152602001828054610fcd90611d16565b801561101a5780601f10610fef5761010080835404028352916020019161101a565b820191906000526020600020905b815481529060010190602001808311610ffd57829003601f168201915b50505050508152602001600382015481526020016004820160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020016005820160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020016006820160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020016006820160149054906101000a900460ff161515151581526020016006820160159054906101000a900460ff161515151581526020016006820160169054906101000a900460ff1615151515815250509050806000015181602001518260400151836060015184608001518560a001518660c001518760e001518861010001518961012001519a509a509a509a509a509a509a509a509a509a50509193959799509193959799565b8280546111e490611d16565b90600052602060002090601f016020900481019282611206576000855561124d565b82601f1061121f57805160ff191683800117855561124d565b8280016001018555821561124d579182015b8281111561124c578251825591602001919060010190611231565b5b50905061125a919061125e565b5090565b5b8082111561127757600081600090555060010161125f565b5090565b600061128e61128984611bf2565b611bc1565b9050828152602081018484840111156112a657600080fd5b6112b1848285611cd4565b509392505050565b6000813590506112c881611dc1565b92915050565b6000813590506112dd81611dd8565b92915050565b600082601f8301126112f457600080fd5b813561130484826020860161127b565b91505092915050565b60008135905061131c81611def565b92915050565b60006020828403121561133457600080fd5b6000611342848285016112b9565b91505092915050565b60006020828403121561135d57600080fd5b600061136b848285016112ce565b91505092915050565b6000806040838503121561138757600080fd5b6000611395858286016112ce565b925050602083013567ffffffffffffffff8111156113b257600080fd5b6113be858286016112e3565b9150509250929050565b600080604083850312156113db57600080fd5b60006113e9858286016112ce565b92505060206113fa8582860161130d565b9150509250929050565b6000806040838503121561141757600080fd5b600083013567ffffffffffffffff81111561143157600080fd5b61143d858286016112e3565b925050602061144e8582860161130d565b9150509250929050565b60006020828403121561146a57600080fd5b60006114788482850161130d565b91505092915050565b600061148d8383611515565b60208301905092915050565b6114a281611c82565b82525050565b60006114b382611c32565b6114bd8185611c55565b93506114c883611c22565b8060005b838110156114f95781516114e08882611481565b97506114eb83611c48565b9250506001810190506114cc565b5085935050505092915050565b61150f81611c94565b82525050565b61151e81611ca0565b82525050565b61152d81611ca0565b82525050565b600061153e82611c3d565b6115488185611c66565b9350611558818560208601611ce3565b61156181611db0565b840191505092915050565b600061157782611c3d565b6115818185611c77565b9350611591818560208601611ce3565b80840191505092915050565b60006115aa602483611c66565b91507f4f6e6c7920746865206469737472696275746f722063616e207570646174652060008301527f74686973000000000000000000000000000000000000000000000000000000006020830152604082019050919050565b6000611610601083611c66565b91507f416c7265616479207665726966696564000000000000000000000000000000006000830152602082019050919050565b6000611650601383611c66565b91507f4f6e6c79204f46412063616e20766572696679000000000000000000000000006000830152602082019050919050565b6000611690602283611c66565b91507f4f6e6c7920746865206661726d65722063616e20726567697374657220676f6f60008301527f64730000000000000000000000000000000000000000000000000000000000006020830152604082019050919050565b60006116f6603a83611c66565b91507f476f6f6473206d757374206265207665726966696564206279204f464120626560008301527f666f7265207570646174696e67206172726976616c20646174650000000000006020830152604082019050919050565b600061175c601c83611c66565b91507f4172726976616c206461746520616c72656164792075706461746564000000006000830152602082019050919050565b600061179c602e83611c66565b91507f4469737472696275746f72206172726976616c2064617465206d75737420626560008301527f20757064617465642066697273740000000000000000000000000000000000006020830152604082019050919050565b6000611802602183611c66565b91507f4f6e6c79207468652072657461696c65722063616e207570646174652074686960008301527f73000000000000000000000000000000000000000000000000000000000000006020830152604082019050919050565b61186481611cca565b82525050565b61187b61187682611cca565b611d48565b82525050565b600061188d828661156c565b9150611899828561186a565b6020820191506118a9828461186a565b602082019150819050949350505050565b60006020820190506118cf6000830184611499565b92915050565b600060208201905081810360008301526118ef81846114a8565b905092915050565b600060208201905061190c6000830184611524565b92915050565b600060a0820190506119276000830188611524565b6119346020830187611499565b81810360408301526119468186611533565b9050611955606083018561185b565b611962608083018461185b565b9695505050505050565b60006060820190506119816000830186611524565b61198e6020830185611506565b61199b604083018461185b565b949350505050565b60006040820190506119b86000830185611524565b81810360208301526119ca8184611533565b90509392505050565b60006040820190506119e86000830185611524565b6119f5602083018461185b565b9392505050565b6000610140820190508181036000830152611a17818d611533565b9050611a26602083018c61185b565b8181036040830152611a38818b611533565b9050611a47606083018a61185b565b611a546080830189611499565b611a6160a0830188611499565b611a6e60c0830187611499565b611a7b60e0830186611506565b611a89610100830185611506565b611a97610120830184611506565b9b9a5050505050505050505050565b60006020820190508181036000830152611abf8161159d565b9050919050565b60006020820190508181036000830152611adf81611603565b9050919050565b60006020820190508181036000830152611aff81611643565b9050919050565b60006020820190508181036000830152611b1f81611683565b9050919050565b60006020820190508181036000830152611b3f816116e9565b9050919050565b60006020820190508181036000830152611b5f8161174f565b9050919050565b60006020820190508181036000830152611b7f8161178f565b9050919050565b60006020820190508181036000830152611b9f816117f5565b9050919050565b6000602082019050611bbb600083018461185b565b92915050565b6000604051905081810181811067ffffffffffffffff82111715611be857611be7611d81565b5b8060405250919050565b600067ffffffffffffffff821115611c0d57611c0c611d81565b5b601f19601f8301169050602081019050919050565b6000819050602082019050919050565b600081519050919050565b600081519050919050565b6000602082019050919050565b600082825260208201905092915050565b600082825260208201905092915050565b600081905092915050565b6000611c8d82611caa565b9050919050565b60008115159050919050565b6000819050919050565b600073ffffffffffffffffffffffffffffffffffffffff82169050919050565b6000819050919050565b82818337600083830152505050565b60005b83811015611d01578082015181840152602081019050611ce6565b83811115611d10576000848401525b50505050565b60006002820490506001821680611d2e57607f821691505b60208210811415611d4257611d41611d52565b5b50919050565b6000819050919050565b7f4e487b7100000000000000000000000000000000000000000000000000000000600052602260045260246000fd5b7f4e487b7100000000000000000000000000000000000000000000000000000000600052604160045260246000fd5b6000601f19601f8301169050919050565b611dca81611c82565b8114611dd557600080fd5b50565b611de181611ca0565b8114611dec57600080fd5b50565b611df881611cca565b8114611e0357600080fd5b5056fea264697066735822122017ec66a8d6d298fbaa6c21d5c915796d9070543e91363f1eaae34687083600c464736f6c63430008000033";

    private static String librariesLinkedBinary;

    public static final String FUNC_OFA = "OFA";

    public static final String FUNC_ALLUUIDS = "allUUIDs";

    public static final String FUNC_DISTRIBUTOR = "distributor";

    public static final String FUNC_FARMER = "farmer";

    public static final String FUNC_GOODSDATA = "goodsData";

    public static final String FUNC_RETAILER = "retailer";

    public static final String FUNC_STAKES = "stakes";

    public static final String FUNC_REGISTERGOODS = "registerGoods";

    public static final String FUNC_OFAVALIDATEGOODS = "OFAValidateGoods";

    public static final String FUNC_ENTERARRIVALDATETODISTRIBUTOR = "enterArrivalDateToDistributor";

    public static final String FUNC_ENTERARRIVALDATETORETAILER = "enterArrivalDateToRetailer";

    public static final String FUNC_GETGOODSDETAILS = "getGoodsDetails";

    public static final String FUNC_GETALLUUIDS = "getAllUUIDs";

    public static final Event DISTRIBUTORARRIVALDATEENTRY_EVENT = new Event("DistributorArrivalDateEntry", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}, new TypeReference<Utf8String>() {}));
    ;

    public static final Event GOODSREGISTERED_EVENT = new Event("GoodsRegistered", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}, new TypeReference<Address>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event GOODSVERIFIED_EVENT = new Event("GoodsVerified", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}, new TypeReference<Bool>() {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event RETAILERARRIVALDATEENTRY_EVENT = new Event("RetailerArrivalDateEntry", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event STAKEADDED_EVENT = new Event("StakeAdded", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event STAKEWITHDRAWN_EVENT = new Event("StakeWithdrawn", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Uint256>() {}));
    ;

    @Deprecated
    protected SupplyChainPoS(String contractAddress, Web3j web3j, Credentials credentials,
            BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected SupplyChainPoS(String contractAddress, Web3j web3j, Credentials credentials,
            ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected SupplyChainPoS(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected SupplyChainPoS(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static List<DistributorArrivalDateEntryEventResponse> getDistributorArrivalDateEntryEvents(
            TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(DISTRIBUTORARRIVALDATEENTRY_EVENT, transactionReceipt);
        ArrayList<DistributorArrivalDateEntryEventResponse> responses = new ArrayList<DistributorArrivalDateEntryEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            DistributorArrivalDateEntryEventResponse typedResponse = new DistributorArrivalDateEntryEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.uuid = (byte[]) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.arrivalDate = (String) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public static DistributorArrivalDateEntryEventResponse getDistributorArrivalDateEntryEventFromLog(
            Log log) {
        Contract.EventValuesWithLog eventValues = staticExtractEventParametersWithLog(DISTRIBUTORARRIVALDATEENTRY_EVENT, log);
        DistributorArrivalDateEntryEventResponse typedResponse = new DistributorArrivalDateEntryEventResponse();
        typedResponse.log = log;
        typedResponse.uuid = (byte[]) eventValues.getNonIndexedValues().get(0).getValue();
        typedResponse.arrivalDate = (String) eventValues.getNonIndexedValues().get(1).getValue();
        return typedResponse;
    }

    public Flowable<DistributorArrivalDateEntryEventResponse> distributorArrivalDateEntryEventFlowable(
            EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(log -> getDistributorArrivalDateEntryEventFromLog(log));
    }

    public Flowable<DistributorArrivalDateEntryEventResponse> distributorArrivalDateEntryEventFlowable(
            DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(DISTRIBUTORARRIVALDATEENTRY_EVENT));
        return distributorArrivalDateEntryEventFlowable(filter);
    }

    public static List<GoodsRegisteredEventResponse> getGoodsRegisteredEvents(
            TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(GOODSREGISTERED_EVENT, transactionReceipt);
        ArrayList<GoodsRegisteredEventResponse> responses = new ArrayList<GoodsRegisteredEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            GoodsRegisteredEventResponse typedResponse = new GoodsRegisteredEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.uuid = (byte[]) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.farmer = (String) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.itemName = (String) eventValues.getNonIndexedValues().get(2).getValue();
            typedResponse.quantity = (BigInteger) eventValues.getNonIndexedValues().get(3).getValue();
            typedResponse.timestamp = (BigInteger) eventValues.getNonIndexedValues().get(4).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public static GoodsRegisteredEventResponse getGoodsRegisteredEventFromLog(Log log) {
        Contract.EventValuesWithLog eventValues = staticExtractEventParametersWithLog(GOODSREGISTERED_EVENT, log);
        GoodsRegisteredEventResponse typedResponse = new GoodsRegisteredEventResponse();
        typedResponse.log = log;
        typedResponse.uuid = (byte[]) eventValues.getNonIndexedValues().get(0).getValue();
        typedResponse.farmer = (String) eventValues.getNonIndexedValues().get(1).getValue();
        typedResponse.itemName = (String) eventValues.getNonIndexedValues().get(2).getValue();
        typedResponse.quantity = (BigInteger) eventValues.getNonIndexedValues().get(3).getValue();
        typedResponse.timestamp = (BigInteger) eventValues.getNonIndexedValues().get(4).getValue();
        return typedResponse;
    }

    public Flowable<GoodsRegisteredEventResponse> goodsRegisteredEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(log -> getGoodsRegisteredEventFromLog(log));
    }

    public Flowable<GoodsRegisteredEventResponse> goodsRegisteredEventFlowable(
            DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(GOODSREGISTERED_EVENT));
        return goodsRegisteredEventFlowable(filter);
    }

    public static List<GoodsVerifiedEventResponse> getGoodsVerifiedEvents(
            TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(GOODSVERIFIED_EVENT, transactionReceipt);
        ArrayList<GoodsVerifiedEventResponse> responses = new ArrayList<GoodsVerifiedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            GoodsVerifiedEventResponse typedResponse = new GoodsVerifiedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.uuid = (byte[]) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.isVerified = (Boolean) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.timestamp = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public static GoodsVerifiedEventResponse getGoodsVerifiedEventFromLog(Log log) {
        Contract.EventValuesWithLog eventValues = staticExtractEventParametersWithLog(GOODSVERIFIED_EVENT, log);
        GoodsVerifiedEventResponse typedResponse = new GoodsVerifiedEventResponse();
        typedResponse.log = log;
        typedResponse.uuid = (byte[]) eventValues.getNonIndexedValues().get(0).getValue();
        typedResponse.isVerified = (Boolean) eventValues.getNonIndexedValues().get(1).getValue();
        typedResponse.timestamp = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
        return typedResponse;
    }

    public Flowable<GoodsVerifiedEventResponse> goodsVerifiedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(log -> getGoodsVerifiedEventFromLog(log));
    }

    public Flowable<GoodsVerifiedEventResponse> goodsVerifiedEventFlowable(
            DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(GOODSVERIFIED_EVENT));
        return goodsVerifiedEventFlowable(filter);
    }

    public static List<RetailerArrivalDateEntryEventResponse> getRetailerArrivalDateEntryEvents(
            TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(RETAILERARRIVALDATEENTRY_EVENT, transactionReceipt);
        ArrayList<RetailerArrivalDateEntryEventResponse> responses = new ArrayList<RetailerArrivalDateEntryEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            RetailerArrivalDateEntryEventResponse typedResponse = new RetailerArrivalDateEntryEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.uuid = (byte[]) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.arrivalTimestamp = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public static RetailerArrivalDateEntryEventResponse getRetailerArrivalDateEntryEventFromLog(
            Log log) {
        Contract.EventValuesWithLog eventValues = staticExtractEventParametersWithLog(RETAILERARRIVALDATEENTRY_EVENT, log);
        RetailerArrivalDateEntryEventResponse typedResponse = new RetailerArrivalDateEntryEventResponse();
        typedResponse.log = log;
        typedResponse.uuid = (byte[]) eventValues.getNonIndexedValues().get(0).getValue();
        typedResponse.arrivalTimestamp = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
        return typedResponse;
    }

    public Flowable<RetailerArrivalDateEntryEventResponse> retailerArrivalDateEntryEventFlowable(
            EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(log -> getRetailerArrivalDateEntryEventFromLog(log));
    }

    public Flowable<RetailerArrivalDateEntryEventResponse> retailerArrivalDateEntryEventFlowable(
            DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(RETAILERARRIVALDATEENTRY_EVENT));
        return retailerArrivalDateEntryEventFlowable(filter);
    }

    public static List<StakeAddedEventResponse> getStakeAddedEvents(
            TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(STAKEADDED_EVENT, transactionReceipt);
        ArrayList<StakeAddedEventResponse> responses = new ArrayList<StakeAddedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            StakeAddedEventResponse typedResponse = new StakeAddedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.validator = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public static StakeAddedEventResponse getStakeAddedEventFromLog(Log log) {
        Contract.EventValuesWithLog eventValues = staticExtractEventParametersWithLog(STAKEADDED_EVENT, log);
        StakeAddedEventResponse typedResponse = new StakeAddedEventResponse();
        typedResponse.log = log;
        typedResponse.validator = (String) eventValues.getNonIndexedValues().get(0).getValue();
        typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
        return typedResponse;
    }

    public Flowable<StakeAddedEventResponse> stakeAddedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(log -> getStakeAddedEventFromLog(log));
    }

    public Flowable<StakeAddedEventResponse> stakeAddedEventFlowable(
            DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(STAKEADDED_EVENT));
        return stakeAddedEventFlowable(filter);
    }

    public static List<StakeWithdrawnEventResponse> getStakeWithdrawnEvents(
            TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(STAKEWITHDRAWN_EVENT, transactionReceipt);
        ArrayList<StakeWithdrawnEventResponse> responses = new ArrayList<StakeWithdrawnEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            StakeWithdrawnEventResponse typedResponse = new StakeWithdrawnEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.validator = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public static StakeWithdrawnEventResponse getStakeWithdrawnEventFromLog(Log log) {
        Contract.EventValuesWithLog eventValues = staticExtractEventParametersWithLog(STAKEWITHDRAWN_EVENT, log);
        StakeWithdrawnEventResponse typedResponse = new StakeWithdrawnEventResponse();
        typedResponse.log = log;
        typedResponse.validator = (String) eventValues.getNonIndexedValues().get(0).getValue();
        typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
        return typedResponse;
    }

    public Flowable<StakeWithdrawnEventResponse> stakeWithdrawnEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(log -> getStakeWithdrawnEventFromLog(log));
    }

    public Flowable<StakeWithdrawnEventResponse> stakeWithdrawnEventFlowable(
            DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(STAKEWITHDRAWN_EVENT));
        return stakeWithdrawnEventFlowable(filter);
    }

    public RemoteFunctionCall<String> OFA() {
        final Function function = new Function(FUNC_OFA, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<byte[]> allUUIDs(BigInteger param0) {
        final Function function = new Function(FUNC_ALLUUIDS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteFunctionCall<String> distributor() {
        final Function function = new Function(FUNC_DISTRIBUTOR, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<String> farmer() {
        final Function function = new Function(FUNC_FARMER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<Tuple10<String, BigInteger, String, BigInteger, String, String, String, Boolean, Boolean, Boolean>> goodsData(
            byte[] param0) {
        final Function function = new Function(FUNC_GOODSDATA, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Uint256>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Uint256>() {}, new TypeReference<Address>() {}, new TypeReference<Address>() {}, new TypeReference<Address>() {}, new TypeReference<Bool>() {}, new TypeReference<Bool>() {}, new TypeReference<Bool>() {}));
        return new RemoteFunctionCall<Tuple10<String, BigInteger, String, BigInteger, String, String, String, Boolean, Boolean, Boolean>>(function,
                new Callable<Tuple10<String, BigInteger, String, BigInteger, String, String, String, Boolean, Boolean, Boolean>>() {
                    @Override
                    public Tuple10<String, BigInteger, String, BigInteger, String, String, String, Boolean, Boolean, Boolean> call(
                            ) throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple10<String, BigInteger, String, BigInteger, String, String, String, Boolean, Boolean, Boolean>(
                                (String) results.get(0).getValue(), 
                                (BigInteger) results.get(1).getValue(), 
                                (String) results.get(2).getValue(), 
                                (BigInteger) results.get(3).getValue(), 
                                (String) results.get(4).getValue(), 
                                (String) results.get(5).getValue(), 
                                (String) results.get(6).getValue(), 
                                (Boolean) results.get(7).getValue(), 
                                (Boolean) results.get(8).getValue(), 
                                (Boolean) results.get(9).getValue());
                    }
                });
    }

    public RemoteFunctionCall<String> retailer() {
        final Function function = new Function(FUNC_RETAILER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<BigInteger> stakes(String param0) {
        final Function function = new Function(FUNC_STAKES, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> registerGoods(String _itemName,
            BigInteger _quantity) {
        final Function function = new Function(
                FUNC_REGISTERGOODS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_itemName), 
                new org.web3j.abi.datatypes.generated.Uint256(_quantity)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> OFAValidateGoods(byte[] _uuid) {
        final Function function = new Function(
                FUNC_OFAVALIDATEGOODS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(_uuid)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> enterArrivalDateToDistributor(byte[] _uuid,
            String _arrivalDate) {
        final Function function = new Function(
                FUNC_ENTERARRIVALDATETODISTRIBUTOR, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(_uuid), 
                new org.web3j.abi.datatypes.Utf8String(_arrivalDate)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> enterArrivalDateToRetailer(byte[] _uuid,
            BigInteger _arrivalTimestamp) {
        final Function function = new Function(
                FUNC_ENTERARRIVALDATETORETAILER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(_uuid), 
                new org.web3j.abi.datatypes.generated.Uint256(_arrivalTimestamp)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<Tuple10<String, BigInteger, String, BigInteger, String, String, String, Boolean, Boolean, Boolean>> getGoodsDetails(
            byte[] _uuid) {
        final Function function = new Function(FUNC_GETGOODSDETAILS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(_uuid)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Uint256>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Uint256>() {}, new TypeReference<Address>() {}, new TypeReference<Address>() {}, new TypeReference<Address>() {}, new TypeReference<Bool>() {}, new TypeReference<Bool>() {}, new TypeReference<Bool>() {}));
        return new RemoteFunctionCall<Tuple10<String, BigInteger, String, BigInteger, String, String, String, Boolean, Boolean, Boolean>>(function,
                new Callable<Tuple10<String, BigInteger, String, BigInteger, String, String, String, Boolean, Boolean, Boolean>>() {
                    @Override
                    public Tuple10<String, BigInteger, String, BigInteger, String, String, String, Boolean, Boolean, Boolean> call(
                            ) throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple10<String, BigInteger, String, BigInteger, String, String, String, Boolean, Boolean, Boolean>(
                                (String) results.get(0).getValue(), 
                                (BigInteger) results.get(1).getValue(), 
                                (String) results.get(2).getValue(), 
                                (BigInteger) results.get(3).getValue(), 
                                (String) results.get(4).getValue(), 
                                (String) results.get(5).getValue(), 
                                (String) results.get(6).getValue(), 
                                (Boolean) results.get(7).getValue(), 
                                (Boolean) results.get(8).getValue(), 
                                (Boolean) results.get(9).getValue());
                    }
                });
    }

    public RemoteFunctionCall<List> getAllUUIDs() {
        final Function function = new Function(FUNC_GETALLUUIDS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Bytes32>>() {}));
        return new RemoteFunctionCall<List>(function,
                new Callable<List>() {
                    @Override
                    @SuppressWarnings("unchecked")
                    public List call() throws Exception {
                        List<Type> result = (List<Type>) executeCallSingleValueReturn(function, List.class);
                        return convertToNative(result);
                    }
                });
    }

    @Deprecated
    public static SupplyChainPoS load(String contractAddress, Web3j web3j, Credentials credentials,
            BigInteger gasPrice, BigInteger gasLimit) {
        return new SupplyChainPoS(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static SupplyChainPoS load(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new SupplyChainPoS(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static SupplyChainPoS load(String contractAddress, Web3j web3j, Credentials credentials,
            ContractGasProvider contractGasProvider) {
        return new SupplyChainPoS(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static SupplyChainPoS load(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new SupplyChainPoS(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<SupplyChainPoS> deploy(Web3j web3j, Credentials credentials,
            ContractGasProvider contractGasProvider) {
        return deployRemoteCall(SupplyChainPoS.class, web3j, credentials, contractGasProvider, getDeploymentBinary(), "");
    }

    @Deprecated
    public static RemoteCall<SupplyChainPoS> deploy(Web3j web3j, Credentials credentials,
            BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(SupplyChainPoS.class, web3j, credentials, gasPrice, gasLimit, getDeploymentBinary(), "");
    }

    public static RemoteCall<SupplyChainPoS> deploy(Web3j web3j,
            TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(SupplyChainPoS.class, web3j, transactionManager, contractGasProvider, getDeploymentBinary(), "");
    }

    @Deprecated
    public static RemoteCall<SupplyChainPoS> deploy(Web3j web3j,
            TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(SupplyChainPoS.class, web3j, transactionManager, gasPrice, gasLimit, getDeploymentBinary(), "");
    }

    public static void linkLibraries(List<Contract.LinkReference> references) {
        librariesLinkedBinary = linkBinaryWithReferences(BINARY, references);
    }

    private static String getDeploymentBinary() {
        if (librariesLinkedBinary != null) {
            return librariesLinkedBinary;
        } else {
            return BINARY;
        }
    }

    public static class DistributorArrivalDateEntryEventResponse extends BaseEventResponse {
        public byte[] uuid;

        public String arrivalDate;
    }

    public static class GoodsRegisteredEventResponse extends BaseEventResponse {
        public byte[] uuid;

        public String farmer;

        public String itemName;

        public BigInteger quantity;

        public BigInteger timestamp;
    }

    public static class GoodsVerifiedEventResponse extends BaseEventResponse {
        public byte[] uuid;

        public Boolean isVerified;

        public BigInteger timestamp;
    }

    public static class RetailerArrivalDateEntryEventResponse extends BaseEventResponse {
        public byte[] uuid;

        public BigInteger arrivalTimestamp;
    }

    public static class StakeAddedEventResponse extends BaseEventResponse {
        public String validator;

        public BigInteger amount;
    }

    public static class StakeWithdrawnEventResponse extends BaseEventResponse {
        public String validator;

        public BigInteger amount;
    }
}
