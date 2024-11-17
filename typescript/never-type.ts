function fail(msg: string): never {
    throw new Error(msg);
}
try {
    fail('error');
} catch (error) {
    console.log('Catch ',error);
}