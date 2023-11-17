document.getElementById('paymentForm').addEventListener('submit', function (event) {
    event.preventDefault();

    const formData = {
        cardNumber: document.getElementById('cardNumber').value,
        cardName: document.getElementById('cardName').value,
        expiryDate: document.getElementById('expiryDate').value,
        securityCode: document.getElementById('securityCode').value
    };

    fetch('/api/payment/process', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(formData)
    })
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.json();
        })
        .then(data => {
            console.log('Success:', data);
            alert('Payment processed successfully');
        })
        .catch(error => {
            console.error('Error:', error);
            alert('Error processing payment: ' + error.message);
        });
});
