package br.com.hugoogle.api.services;

import br.com.hugoogle.api.dtos.FornecedorProdutoDto;
import br.com.hugoogle.api.model.*;
import br.com.hugoogle.api.model.PedidoItem;
import br.com.hugoogle.api.repositories.*;
import br.com.hugoogle.api.vo.RelatorioDeVendasVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class DBService {

    @Autowired
    private FornecedorRepository fornecedorRepository;

    @Autowired
    private LojaRepository lojaRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private PedidoItemRepository pedidoItemRepository;
    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private DepartamentoRepository departamentoRepository;

    @Autowired
    private FornecedorProdutoRepository fornecedorProdutoRepository;

    @Autowired
    private CodigoBarraRepository codigoBarraRepository;
    public void instanciaDB() {
        Departamento departamento1 = new Departamento("Limpeza");
        departamentoRepository.save(departamento1);

        Departamento depLimpeza = departamentoRepository.findByDescricao(departamento1.getDescricao());

        Produto produto1 = new Produto("ACHOCOLATADO NESCAU 2.0", depLimpeza, new BigDecimal(10));
        Produto produto2 = new Produto("LEITE CONDENSADO MOÇA", depLimpeza, new BigDecimal(12));
        Produto produto3 = new Produto("ACUCAR REFINADO UNIAO 1KG", depLimpeza, new BigDecimal(12));
        Produto produto4 = new Produto("ACUCAR DE CONFEITEIRO UNIAO GLAÇUCAR", depLimpeza, new BigDecimal(12));
        Produto produto5 = new Produto("CERVEJA BUDWEISER", depLimpeza, new BigDecimal(12));
        Produto produto6 = new Produto("SALGADINHO FANDANGOS QUEIJO", depLimpeza, new BigDecimal(12));
        Produto produto7 = new Produto("REFRIGERANTE COCA-COLA 2LT", depLimpeza, new BigDecimal(12));


        produtoRepository.saveAll(List.of(produto1, produto2, produto3, produto4, produto5, produto6, produto7));

        Produto NovoProduto1 = produtoRepository.findByDescricao(produto1.getDescricao());
        Produto NovoProduto2 = produtoRepository.findByDescricao(produto2.getDescricao());

        CodigoBarra codigoBarra  = new CodigoBarra(produto1,7896032501010L);
        CodigoBarra codigoBarra1 = new CodigoBarra(produto2,7896037001012L);
        CodigoBarra codigoBarra2 = new CodigoBarra(produto3,7895032504010L);
        CodigoBarra codigoBarra3 = new CodigoBarra(produto4,7896055503333L);
        CodigoBarra codigoBarra4 = new CodigoBarra(produto5,7897775010120L);
        CodigoBarra codigoBarra5 = new CodigoBarra(produto6,7896032589510L);
        CodigoBarra codigoBarra6 = new CodigoBarra(produto7,7896058512360L);



        codigoBarraRepository.saveAll(List.of(codigoBarra, codigoBarra1, codigoBarra2, codigoBarra3, codigoBarra4, codigoBarra5, codigoBarra6));
        Fornecedor fornecedorLimpeza1 = new Fornecedor("LOLO", null, "56.751.294/0001-48", "940458982");
        Fornecedor fornecedorLimpeza2 = new Fornecedor("LOLO", "341.405.620-80", null, "940458982");
        fornecedorRepository.saveAll(List.of(fornecedorLimpeza1, fornecedorLimpeza2));

        Loja loja1 = new Loja("Loja1","761.758.420-22", null, "58125834");
        Loja loja2 = new Loja("Loja2",null, "29.855.060/0001-78", "58125834");
        lojaRepository.saveAll(List.of(loja1, loja2));

        Pedido pedido1 = new Pedido(fornecedorLimpeza1,loja1);
        Pedido pedido2 = new Pedido(fornecedorLimpeza1,loja1);
        pedido1.adicionarItem(new PedidoItem(pedido1, NovoProduto1, 10.00));
        pedido2.adicionarItem(new PedidoItem(pedido2, NovoProduto2, 12.00));
        pedidoRepository.saveAll(List.of(pedido1, pedido2));

        PedidoItem pedidoItem1 = new PedidoItem(pedido1, NovoProduto1, 10.00);
        PedidoItem pedidoItem2 = new PedidoItem(pedido1, NovoProduto2, 12.00);


        pedidoItemRepository.saveAll(List.of(pedidoItem1, pedidoItem2));


        List<PedidoItem> listQuantidade = new ArrayList<>();

        listQuantidade.add(pedidoItem1);
        listQuantidade.add(pedidoItem2);

        Map<Long, List<PedidoItem>> group = listQuantidade.stream().collect(Collectors.groupingBy(
                PedidoItem::getId));

        System.out.println("test" + group);
//
//
//        Map<Long, Set<Double>> groups = listQuantidade.stream().collect(Collectors.groupingBy(
//                PedidoItem::getId, Collectors.mapping(PedidoItem::getQuantidade, Collectors.toSet())));
//
////        Optional<Map.Entry<Integer, Set<Integer>>> max = groups.entrySet().stream()
////                .max(Comparator.comparing(Integer::valueOf)).get();
//        listQuantidade.stream().max((entry1, entry2) -> entry1.getQuantidade() > entry2.getQuantidade() ? 1 : -1).get().getId();
//
//        System.out.println("teste2" + listQuantidade);
//
//
//        System.out.println("test" + group);
//
//        System.out.println("teste" + groups);
//
//        Map<Long, Optional<Double>> groups1 = listQuantidade.stream().collect(Collectors.groupingBy(
//                PedidoItem::getId, Collectors.mapping(PedidoItem::getQuantidade, Collectors.maxBy(Comparator.naturalOrder()))));
//
//        System.out.println("teste3" + groups1);
//
//        System.out.println(listQuantidade.stream().toList());
//
//
////               .forEach((integer, integer2) -> );
//        //Stream<Order> collect =
//        listQuantidade.stream().collect(
//                        Collectors.collectingAndThen(
//                                Collectors.groupingBy(PedidoItem::getId),
//                                map -> map.values().stream()
//                                        .map(l -> l.stream().max(Comparator.comparing(PedidoItem::getQuantidade)).orElse(null))
//
//                                        .filter(Objects::nonNull)))
//                .max(((p1, p2) -> (Integer.parseInt(p2.getQuantidade().toString()))))
//                .map(pedido -> pedido.getQuantidade() - 1)
//                .stream().forEach(System.out::println);
//

        System.out.println("HUGO");
        // Optional<Order> max = collect.collect(Collectors.toList()).stream().max((o1, o2) -> (o1.getQuantidade() + o2.getQuantidade()));
        //  max.stream().forEach(f-> System.out.println(f.getQuantidade()));

        Fornecedor fornecedor1 = new Fornecedor("Hugoogle Ltda", "053.144.620-44", null, "1212");
        Fornecedor fornecedor2 = new Fornecedor("Heloisa Ltda", null, "08.445.721/0001-17", "952");


        Loja loja = new Loja("Lolo", "712.697.560-01", null, "940458982");
        Pedido pedido = new Pedido(fornecedor1, loja);

        fornecedor1.getPedidoList().add(pedido);
        loja.getPedidoList().add(pedido);
        fornecedorRepository.saveAll(Arrays.asList(fornecedor1, fornecedor2));
        lojaRepository.saveAll(Arrays.asList(loja));
        pedidoRepository.saveAll(Arrays.asList(pedido));
     //   BigDecimal valorTotalVendido = pedidoRepository.getValorTotalVendido();
        List<Object[]> relatorioVendaVo = pedidoRepository.getRelatorioVendaVo();

        for (Object[] ob: relatorioVendaVo ) {
            System.out.println(ob[0]);
        System.out.println(ob[1]);
            System.out.println(ob[2]);
        }

        List<RelatorioDeVendasVo> relatorioVendasVo = pedidoRepository.getRelatorioVendasVo();

       System.out.println(relatorioVendasVo);

        List<Pedido> pedidos = pedidoRepository.buscarPedidoPorLoja(3);

        pedidos.forEach(pedidosPorLoja ->{

            System.out.println("Loja: " + pedidosPorLoja.getLoja() + " Total: " + pedidosPorLoja.getValorTotal());
        });

     FornecedorProduto fornecedorProduto1 = new FornecedorProduto(fornecedor1, produto1, 12.00, new BigDecimal(125.6));
     FornecedorProduto fornecedorProduto2 = new FornecedorProduto(fornecedor2, produto1, 12.00, new BigDecimal(123.0));

        fornecedorProdutoRepository.save(fornecedorProduto1);

        fornecedorProdutoRepository.save(fornecedorProduto2);

        List<FornecedorProdutoDto> byGtin = fornecedorProdutoRepository.listaFornecedorGtin(7896032501010L);

//        byGtin.setPrecos(fornecedorProdutoRepository.listaPrecoQuantidadePorGtin(7896032501010L));

        System.out.println(byGtin);

    }


//\
//    class PedidoItem {
//        public int id;
//        public Integer quantidade;
//
//        PedidoItem(int id, Integer quantidade) {
//            this.id = id;
//            this.quantidade = quantidade;
//        }
//
//        public int getId() {
//            return id;
//        }
//
//        public void setId(int id) {
//            this.id = id;
//        }
//
//        public Integer getQuantidade() {
//            return quantidade;
//        }
//
//        public void setQuantidade(Integer quantidade) {
//            this.quantidade = quantidade;
//        }
//
//        public int compare(PedidoItem pedido, PedidoItem outroPedidoItem) {
//            return pedido.getQuantidade().compareTo(outroPedidoItem.getQuantidade());
//        }
//    }0
}
