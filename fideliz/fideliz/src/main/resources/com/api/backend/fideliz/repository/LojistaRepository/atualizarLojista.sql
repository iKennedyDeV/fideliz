UPDATE LOJISTA
SET nome = :nome,
    contato = :contato,
    link_cardapio = :linkCardapio,
    link_img = :linkImage,
    link_logo = :linkLogo
WHERE cnpj = :cnpj;
